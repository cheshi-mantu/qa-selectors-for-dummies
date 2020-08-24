package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Environment;
import helpers.LoadCredentialsHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.*;
import static helpers.Environment.*;
import static io.qameta.allure.Allure.step;

public class TestBase {
    static String htmlFilePath = "";
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        configureSelenide();
        Configuration.startMaximized = true;
        if (isRemoteDriver) {
            htmlFilePath = url;
        } else {
            File htmlFile = new File(Environment.url);
            htmlFilePath = htmlFile.getAbsolutePath();
        }
    }
    @BeforeEach
    public void prepareForTest() {
        if (webUrl != null) {
            step("Open web url", ()-> {
                open(webUrl);
            });
            step("Login to jenkins", () -> {
                $(byName("j_username")).val(jUserName);
                $(byName("j_password")).val(jPassword).pressEnter();
            });
        }
    }
    @AfterEach
    public void afterEach(){
        String sessionId = getSessionId();
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        closeWebDriver();
        if (isVideoOn) attachVideo(sessionId);
    }
}
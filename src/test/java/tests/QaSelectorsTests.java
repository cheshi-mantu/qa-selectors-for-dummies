package tests;

import helpers.LoadCredentialsHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

import static helpers.Environment.webUrl;
import static io.qameta.allure.Allure.step;

@Epic("QA selectors for dummies")
@Story("Play with selectors locally")
@Tag("selectors_tests")
class QaSelectorsTests extends TestBase {

    @Test
    @DisplayName("Open page click H1")
    void pageOpenH1Click() {
        step ("Open html page", () -> open(htmlFilePath));
        if (webUrl != null) {

            step("Login to jenkins", () -> {
                $("#j_username").setValue(LoadCredentialsHelper.getCredentialsFromJson("jenkins.secret", "j_username"));
                $(byName("j_password")).setValue(LoadCredentialsHelper.getCredentialsFromJson("jenkins.secret", "j_password")).pressEnter();
        });
        }

        step("Locate H1 and click", () -> {
            $("h1.black").click();
        });
        step("Check", () -> {
            $("#my_message").shouldHave(text("tag: H1"));
        });
    }
}


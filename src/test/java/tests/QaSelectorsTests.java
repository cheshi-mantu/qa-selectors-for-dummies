package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import static io.qameta.allure.Allure.step;

@Epic("QA selectors for dummies")
@Story("Play with selectors locally")
@Tag("selectors_tests")
class QaSelectorsTests extends TestBase {

    @Test
    @DisplayName("Open page click H1")
    void pageOpenH1Click() {
        step ("Open html page", () -> open(htmlFilePath));
        step("Locate H1 and click", () -> {
            $("h1.black").click();
        });
        step("Check", () -> {
            $("#my_message").shouldHave(text("tag: H1"));
        });
    }
}


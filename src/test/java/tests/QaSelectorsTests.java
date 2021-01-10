package tests;

import io.qameta.allure.Description;
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
            $("h1").shouldNotHave(text("but different")).click();
        });
        step("Check", () -> {
            $("#my_message").shouldHave(text("tag: H1"));
        });
    }
    @Test
    @DisplayName("Open page click link with class equal")
    void pageOpenAwithClassEqualClick() {
        step ("Open html page", () -> open(htmlFilePath));
        step("Locate link with class equal an click", () -> {
            $(".equal").click();
        });
        step("Check link is clicked", () -> {
            $("#my_message").shouldHave(text("equal"));
        });
    }

    @Test
    @DisplayName("Check if login and password fields are enabled when checkbox is checked")
    void pageOpenCheckBoxClick() {
        step ("Open html page", () -> open(htmlFilePath));
        step("Find checkbox by ID and click it", () -> {
            $("#enabler").click(); //   то же самое, что
//            $(byId("enabler")).click();
        });
        step("Check", () -> {
            $("#login").shouldBe(enabled);
            $("#secret").shouldBe(enabled);
            $("[value='Submit']").shouldBe(enabled);
        });
    }
    @Test
    @DisplayName("Brief description of this test")
    @Description("Long description of this very test. Some details on what is being done")
    void pseudoOpenCheckBoxClickCheckFormFieldsEnabled() {
        step ("Open html page");
        step ("Find check box by its ID. Click ");
        step ("Check if login field is enabled");
        step ("Check if password field is enabled");
        step ("Check if Submit button is enabled");
    }
    @Test
    @DisplayName("Checkbox and button")
    void pageOpenCheckBoxClickCheckFormFieldsEnabled() {
        step ("Open html page", ()->{
            open(htmlFilePath);
        });
        step ("Find check box by its ID. Click ", ()->{
            $("#enabler").click();
        });
        step ("Check if login field is enabled", ()->{
            $("#login").shouldBe(enabled);
        });
        step ("Check if password field is enabled", ()->{
            $("#secret").shouldBe(enabled);
        });
//        step ("Check if Submit button is enabled", ()->{
//            $("[value='Submit']").shouldBe(enabled);
//        });
        step ("Check if Submit button is enabled", ()->{
            $$("input").findBy(attribute("value", "Submit")).shouldBe(enabled);
        });
    }
    @Test
    @DisplayName("Click the button with 'Click me' text")
    void pageOpenButtonClickMeClick() {
        step ("Open html page", ()->{
            open(htmlFilePath);
        });
        step ("Find the button with text 'Click me' and click it ", ()->{
            $("button.button_violet_dashed").shouldHave(text("Click me")).click();
//            $$("button").findBy(text("Click me")).click();
        });
        step("Check link is clicked", () -> {
            $("#my_message").shouldHave(text("text: Click me"));
        });

    }
}
package pages;

import base.PageBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.getLocator;

public class LoginMessagePage extends PageBase {

    @Step("Get login result message")
    public void validateMessage(String message) {
        $(getLocator("LoginMessagePage.messageElement")).shouldHave(text(message));
    }
}

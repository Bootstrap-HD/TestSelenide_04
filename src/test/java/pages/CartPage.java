package pages;

import base.PageBase;
import io.qameta.allure.Step;

import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.getLocator;

public class CartPage extends PageBase {

    @Step("Opening the cart")
    public void goToCart() {
        $(getLocator("CartPage.cartButton")).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Validate of the quantity of goods")
    public void validateText(String text) {
        $(getLocator("CartPage.textCartButton")).shouldHave(text(text));
    }

    @Step("Validate of product article")
    public void validateElementText(String text) {
        $(getLocator("CartPage.productArticle")).shouldHave((text(text)));
    }

}

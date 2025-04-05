package pages;

import base.PageBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.getLocator;

public class ProductPage extends PageBase {

    @Step("Adding a product to the cart")
    public void setAddProductInCart() {
        //$(getLocator("ProductPage.addProductButton")).shouldBe(visible, Duration.ofSeconds(10)).click();
        $(getLocator("ProductPage.addProductButton")).click();
    }
}

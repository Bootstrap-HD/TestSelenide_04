package pages;

import base.PageBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.Locators.getLocator;

public class CatalogPage extends PageBase {

    @Step("Opening a product card")
    public void catalogElementClick() {
        //$(getLocator("CatalogPage.catalogElementP5")).shouldBe(visible, Duration.ofSeconds(10)).click();
        $(getLocator("CatalogPage.catalogElementP5")).click();
    }

    @Step("Validate the quantity of products in the catalog")
    public void validateProductQuantity(int quantity) {
        $$(getLocator("CatalogPage.elementsCatalogLi")).should(size(quantity));
    }
}

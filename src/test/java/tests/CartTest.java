package tests;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CatalogPage;
import pages.HeaderMenuPage;
import pages.ProductPage;

@Epic("Test Cart")
@Feature("UI Cart form")
public class CartTest extends TestBase {

    @Story("Cart tests: positive")
    @Test(description = "Checking the quantity of products in the cart")
    public void testCartQuantityItems() {
        HeaderMenuPage headerMenuPage = new HeaderMenuPage();
        CatalogPage catalogPage = new CatalogPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        headerMenuPage.goToCatalog();
        catalogPage.catalogElementClick();
        productPage.setAddProductInCart();
        cartPage.validateText("1");
    }

    @Story("Cart tests: positive")
    @Test(description = "Checking the added the product in the cart")
    public void testCartValidateGood() {
        HeaderMenuPage headerMenuPage = new HeaderMenuPage();
        CatalogPage catalogPage = new CatalogPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        headerMenuPage.goToCatalog();
        catalogPage.catalogElementClick();
        productPage.setAddProductInCart();
        cartPage.validateText("1");
        cartPage.goToCart();
        cartPage.validateElementText("[SKU: RD005]");
    }
}

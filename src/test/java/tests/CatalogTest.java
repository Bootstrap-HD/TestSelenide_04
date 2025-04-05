package tests;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HeaderMenuPage;

@Epic("Test Catalog")
@Feature("UI Catalog form")
public class CatalogTest extends TestBase {

    @Story("Catalog tests: positive")
    @Test(description = "Checking the quantity of products in the catalog")
    public void testCatalogQuantityGoods() {
        HeaderMenuPage headerMenuPage = new HeaderMenuPage();
        headerMenuPage.goToCatalog();

        CatalogPage catalogPage = new CatalogPage();

        catalogPage.validateProductQuantity(5);
    }
}

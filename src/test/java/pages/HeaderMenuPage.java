package pages;

import base.PageBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.getLocator;

public class HeaderMenuPage extends PageBase {

    @Step("Opening the catalog")
    public void goToCatalog() {
        $(getLocator("HeaderMenuPage.catalogButton")).click();
    }
}

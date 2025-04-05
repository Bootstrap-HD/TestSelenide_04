package tests;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.LoginMessagePage;
import pages.LoginPage;
import static helpers.EnvironmentData.getEnvironmentData;

@Epic("Test Login")
@Feature("UI Login form")
public class LoginTest extends TestBase {

    @Story("Login tests: positive")
    @Test(description = "Attempt to login with correct credentials: success message should appear")
    public void testAutorization() {
        LoginPage loginPage = new LoginPage();
        LoginMessagePage loginMessagePage = new LoginMessagePage();

        loginPage.login(getEnvironmentData("Dev.email"), getEnvironmentData("Dev.password"));

        loginMessagePage.validateMessage(String.format(getEnvironmentData("Dev.loginSuccessMessage"), getEnvironmentData("Dev.name")));
    }

    @Story("Login tests: positive")
    @Test
    public void testLogOut() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(getEnvironmentData("Dev.email"), getEnvironmentData("Dev.password"));
        LoginMessagePage loginMessagePage = new LoginMessagePage();

        loginPage.logout();

        loginMessagePage.validateMessage(getEnvironmentData("Dev.logoutMessage"));
    }

 /*   @Story("Login tests: negative")
    @Test(description = "Attempt to login with incorrect credentials: failed test")
    public void testAutorizationBroken() {
        LoginPage loginPage = new LoginPage();
        LoginMessagePage loginMessagePage = new LoginMessagePage();

        loginPage.login(getEnvironmentData("Dev.email"), getEnvironmentData("Dev.wrongPassword"));

        loginMessagePage.validateMessage(String.format(getEnvironmentData("Dev.loginSuccessMessage"), getEnvironmentData("Dev.name")));
    }*/
}

package base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.EnvironmentData.getEnvironmentData;

public class TestBase {

    @BeforeMethod
    public void methodSetup() {

        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setVersion();
        caps.setPlatform(Platform.valueOf(System.getProperty("platform", "MAC")));
        caps.setAcceptInsecureCerts(true);
        Configuration.browser = System.getProperty("browser", "safari");
        //Configuration.remote = " http://169.254.170.176:4444/wd/hub";
        Configuration.browserCapabilities = caps;
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;

        open(getEnvironmentData("Dev.url"));
        getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void methodTeardown() {
        getWebDriver().quit();
    }
}

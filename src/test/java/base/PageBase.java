package base;

import org.openqa.selenium.By;

public class PageBase {

    public By containsText(String text) {
        return By.xpath(String.format("//*[contains(text(),'%s')]", text));
    }
}

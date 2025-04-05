package helpers;

import enums.LocatorType;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Locators {

    private static final Properties props;

    static {
        props = new Properties();

        InputStream is = Locators.class.getResourceAsStream("/locators.properties");

        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println("Error reading from property file");
        }
    }

    public static By getLocator(String element) {
        String locator = props.getProperty(element);

        List<String> parsedElement = new ArrayList<>();
        String[] parsedLocator = locator.split("=", 2);

        if (parsedLocator[0].contains("%")) {
            String replace = parsedLocator[0].replace("%", "");
            parsedElement.add(replace);

            parsedElement.addAll(Arrays.asList(parsedLocator[1].split("==", 2)));
        } else {
            parsedElement.addAll(List.of(parsedLocator));
        }

        switch (LocatorType.valueOf(parsedElement.get(0))) {
            case name -> {
                return By.name(parsedElement.get(1));
            }
            case css -> {
                return parsedElement.size() == 2 ?
                        By.cssSelector(parsedElement.get(1)) :
                        By.cssSelector(String.format(parsedElement.get(1), parsedElement.get(2)));
            }
            case xpath -> {
                return parsedElement.size() == 2 ?
                        By.xpath(parsedElement.get(1)) :
                        By.xpath(String.format(parsedElement.get(1), parsedElement.get(2)));
            }
        }

        return null;
    }
}

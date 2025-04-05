package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentData {
    private static final Properties props;

    static {
        props = new Properties();

        InputStream is = Locators.class.getResourceAsStream("/environmentData.properties");

        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println("Error reading from property file");
        }
    }

    public static String getEnvironmentData(String element) {
        return props.getProperty(element);
    }
}

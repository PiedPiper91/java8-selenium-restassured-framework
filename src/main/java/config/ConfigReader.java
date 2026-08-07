package config;

import exceptions.ConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
//            ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
                PROPERTIES.load(fis);
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    new ConfigurationException(
                            "Failed to load config.properties"
                    )
            );
        }
    }

    public static String getBrowser() {
        return PROPERTIES.getProperty("browser");
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("baseUrl");
    }

    public static String getUsername() {
        return PROPERTIES.getProperty("username");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("password");
    }

    public static int getTimeout() {
        return Integer.parseInt(
                PROPERTIES.getProperty("timeout")
        );
    }


}

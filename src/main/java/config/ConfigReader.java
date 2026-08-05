package config;

import exceptions.ConfigurationException;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            try {
                throw new ConfigurationException("Failed to load properties file");
            } catch (ConfigurationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getTimeout() {
        return properties.getProperty("timeout");
    }


}

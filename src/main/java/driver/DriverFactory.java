package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver createDriver(String browser) {

        switch (browser.trim().toLowerCase()) {

            case "chrome":
                return new ChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                throw new RuntimeException(
                        "Unsupported browser: " + browser
                );
        }
    }
}
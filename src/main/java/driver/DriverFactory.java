package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    WebDriver driver;

    public WebDriver createDriver(String browser) {
        if (driver == null) {
            switch (browser){
                case "chrome":
                    driver = new ChromeDriver();
                case "firefox":
                    driver = new FirefoxDriver();
                default:
                  throw new RuntimeException("Unsupported browser: "+browser);
            }
        }
        return driver;
    }
}
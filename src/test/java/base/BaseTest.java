package base;


import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.LoggerUtil;

import static config.ConfigReader.getBrowser;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    public void setup() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.createDriver(getBrowser());
        LoggerUtil.info("Browser launched");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.LoggerUtil;
import java.time.Duration;
import static config.ConfigReader.getBrowser;
import static constants.FrameworkConstants.DEFAULT_TIMEOUT;

public class SeleniumBasicTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
            DriverFactory driverFactory = new DriverFactory();
            driver = driverFactory.createDriver(getBrowser());
            LoggerUtil.info("Browser launched");
    }

    @Test
    void testOrangeHRMLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoggerUtil.info("Navigated to "+driver.getCurrentUrl());
        LoggerUtil.info("Page Title: "+driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]")));
        usernameInput.sendKeys("Admin");
        passwordInput.sendKeys("admin123");
        loginButton.click();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String currentUrl = driver.getCurrentUrl();
        LoggerUtil.info("Current URL after login: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("dashboard"),"Login failed. Expected dashboard URL but found: " + currentUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

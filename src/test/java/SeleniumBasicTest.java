import base.BaseTest;
import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.LoggerUtil;
import java.time.Duration;
import static constants.FrameworkConstants.DEFAULT_TIMEOUT;

public class SeleniumBasicTest extends BaseTest {

    @Test
    void testOrangeHRMLogin() {
        driver = BaseTest.getDriver();
        driver.get(ConfigReader.getBaseUrl() + "/web/index.php/auth/login");
        LoggerUtil.info("Navigated to "+driver.getCurrentUrl());
        LoggerUtil.info("Page Title: "+driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]")));
        usernameInput.sendKeys(ConfigReader.getUsername());
        passwordInput.sendKeys(ConfigReader.getPassword());
        loginButton.click();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String currentUrl = driver.getCurrentUrl();
        LoggerUtil.info("Current URL after login: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("dashboard"),"Login failed. Expected dashboard URL but found: " + currentUrl);
    }
}

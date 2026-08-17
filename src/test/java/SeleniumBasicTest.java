import base.BaseTest;
import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String currentUrl = driver.getCurrentUrl();
        LoggerUtil.info("Current URL after login: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("dashboard"),"Login failed. Expected dashboard URL but found: " + currentUrl);
    }
}

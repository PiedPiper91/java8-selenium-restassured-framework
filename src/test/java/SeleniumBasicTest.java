import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.LoggerUtil;

public class SeleniumBasicTest extends BaseTest {

    @Test
    void testOrangeHRMLogin() {
        driver.get(ConfigReader.getBaseUrl() + "/web/index.php/auth/login");
        LoggerUtil.info("Navigated to "+driver.getCurrentUrl());
        LoggerUtil.info("Page Title: "+driver.getTitle());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(),ConfigReader.getPassword());
        String currentUrl = driver.getCurrentUrl();
        LoggerUtil.info("Current URL after login: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("dashboard"),"Login failed. Expected dashboard URL but found: " + currentUrl);
    }
}

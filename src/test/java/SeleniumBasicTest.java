import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.LoggerUtil;

public class SeleniumBasicTest extends BaseTest {

    @DataProvider(name = "loginData")
        public Object[][] loginData() {
        return new Object[][]{
                {"Admin", "admin123", true},
                {"Admin", "WrongPassword", false},
                {"WrongUsername", "Admin123", false}
        };
    }

    @Test(dataProvider = "loginData")
    void testOrangeHRMLogin(String username, String password, Boolean expectedLogin) throws InterruptedException {
        driver.get(ConfigReader.getBaseUrl() + "/web/index.php/auth/login");
        LoggerUtil.info("Navigated to "+driver.getCurrentUrl());
        LoggerUtil.info("Page Title: "+driver.getTitle());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        LoggerUtil.info("Current URL after login: " + currentUrl);
        boolean actualLogin = currentUrl.contains("dashboard");
        Assert.assertEquals(actualLogin, expectedLogin,"Fails due to mismatch between expected and actual Login behaviour");
    }
}

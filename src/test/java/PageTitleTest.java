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

public class PageTitleTest extends BaseTest {

//    @Test
//    void testOrangeHRMLogin() {
//        driver.get(ConfigReader.getBaseUrl() + "/web/index.php/auth/login");
//        LoggerUtil.info("Navigated to "+driver.getCurrentUrl());
//        LoggerUtil.info("Page Title: "+driver.getTitle());
//        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Page Title is not OrangeHRM");
//    }
}

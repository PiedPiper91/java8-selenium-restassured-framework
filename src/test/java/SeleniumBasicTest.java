import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.LoggerUtil;

import javax.xml.datatype.Duration;

import static constants.FrameworkConstants.DEFAULT_TIMEOUT;

public class SeleniumBasicTest {

    WebDriver driver;

    @Test
    void testDateNotNull() throws InterruptedException {
        driver = new ChromeDriver();
        LoggerUtil.info("Browser launched");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoggerUtil.info("Navigated to "+driver.getCurrentUrl());
        LoggerUtil.info("Page Title: "+driver.getTitle());
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]"));
        usernameInput.sendKeys("Admin");
        passwordInput.sendKeys("admin123");
        loginButton.click();
        try {
            driver.wait(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        driver.quit();
    }
}

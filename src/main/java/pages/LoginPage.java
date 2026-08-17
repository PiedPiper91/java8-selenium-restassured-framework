package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import static constants.FrameworkConstants.DEFAULT_TIMEOUT;

public class LoginPage {
     private WebDriver driver;
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
     private By usernameInput= By.name("username");
     private By passwordInput = By.name("password");
     private By loginButton = By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]");

    public LoginPage(WebDriver driver) {
    this.driver = driver;
     }

    public void enterUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]")));
        loginButton.click();
    }

    public void login(){
        this.enterUsername(ConfigReader.getUsername());
        this.enterPassword(ConfigReader.getPassword());
        this.clickLogin();
    }

}

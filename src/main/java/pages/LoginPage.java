package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameInputLocator= By.name("username");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameInputLocator,username);
    }

    public void enterPassword(String password) {
        type(passwordInputLocator,password);
    }

    public void clickLogin() {
        click(loginButtonLocator);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

}

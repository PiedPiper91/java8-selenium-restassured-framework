package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.FrameworkConstants.DEFAULT_TIMEOUT;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );
    }

    public void click(By locator){
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        webElement.click();
    }

    public void type(By locator, String text){
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        webElement.sendKeys(text);
    }

    public String getText(By locator){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement.getText();
    }

    public Boolean isDisplayed(By locator){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement.isDisplayed();
    }

    public WebElement waitForElementVisible(By locator){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    public WebElement waitForElementClickable(By locator){
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }


}

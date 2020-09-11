/**
 * Base Page
 * class which contains a bunch of popular methods, so they can be reused in every page.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    // Singleton driver instantiation
    public BasePage(){
        this.driver = DriverSingleton.getDriverInstance();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://buyme.co.il/");
    }
    

    public static void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public static void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public static void waitVisibilityOfElementLocated (By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void isDisplayedElement (By locator) {
        getWebElement(locator).isDisplayed();
    }

    public static WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}

/**
 * Base Page
 * class which contains a bunch of methods, so they can be reused in every page.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    // Singleton driver instantiation
    public BasePage() throws Exception {
        this.driver = DriverSingleton.getDriverInstance();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void getUrl(String url) {
        driver.get(url);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    public static void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }

    public static void waitelementToBeClickable (By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void isDisplayedElement (By locator) throws Exception {
        getWebElement(locator).isDisplayed();
    }

    public static String getElementText (By locator) throws Exception {
        return getWebElement(locator).getText();
    }

    private static WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}

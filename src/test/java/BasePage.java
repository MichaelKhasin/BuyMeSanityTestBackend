import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * BasePage class is used & contains a bunch of popular methods, so they are reused.
 * RegistrationTest and Home_PickBusiness_SendReceiveInfoTest classes are extend the BasePage.
 */

public class BasePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    // Singleton driver instantiation
    public BasePage() throws Exception {
        this.driver = DriverSingleton.getDriverInstance();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void getUrl(String url) throws Exception{
        driver.get(url);
    }

    public static void reloadUrl() throws Exception{
        driver.navigate().refresh();
    }

    public static String getTitle(String url) throws Exception{
        return driver.getTitle();
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

    public static void quit () throws Exception {
        driver.quit();
    }

    public static int getElementHeight (By locator) throws Exception {
        return getWebElement(locator).getRect().getHeight();
    }

    public static int getElementWidth (By locator) throws Exception {
        return getWebElement(locator).getRect().getWidth();
    }

    public static void actionPerform (String text) throws Exception {
        Actions myAction = new Actions(driver);
        myAction.sendKeys(text);
        myAction.perform();
    }

    public static String getElementColor (By locator) throws Exception {
        return getWebElement(locator).getCssValue("color");
    }

    public static void scrolltoElement (By locator) throws Exception {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(locator));
    }


    private static WebElement getWebElement(By locator) throws Exception {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }



    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}

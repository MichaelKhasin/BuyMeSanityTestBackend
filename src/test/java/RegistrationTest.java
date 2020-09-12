import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends BasePage{

    @Test
    public void test01_registration(){

        clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
        clickElement(By.xpath("//span[@class='text-btn' and @data-ember-action='1154']")); // Click on להרשמה

        sendKeysToElement(By.id("ember1179"), "מיכאל"); // Send name
        sendKeysToElement(By.id("ember1181"), Constants.MY_EMAIL); // Send email
        sendKeysToElement(By.id("valPass"), "Abcd1efgh");  // Send password (temporary)
        sendKeysToElement(By.id("ember1185"), "Abcd1efgh");  // Re-enter password (temporary)

        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-הרשמה ל


    }

    @Test
    public void test02_assertRegistration() {
        // Registration error in case mail already exists - Assertion if "error message" element displayed:
        isDisplayedElement(By.xpath("//div[@class='login-error']"));

        isDisplayedElement(By.id("ember1179")); // Assertion if name element displayed
        isDisplayedElement(By.id("ember1181")); // Assertion if email element displayed
        isDisplayedElement(By.id("valPass")); // Assertion if password element displayed
        isDisplayedElement(By.id("ember1185")); // Assertion if re-enter password element displayed
    }
}

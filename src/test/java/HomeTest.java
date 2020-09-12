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


public class HomeTest extends BasePage{
    @BeforeClass
    public static void runOnceBeforeClass() {
        // Login to BuyMe with existing user
        clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
        sendKeysToElement(By.id("ember1165"), Constants.MY_EMAIL); // Send email
        sendKeysToElement(By.id("ember1167"), Constants.MY_PASSWORD);  // Send password
        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-כניסה ל

    }

    @Test
    public void test01_homeScreen(){
        //clickElement(By.xpath("//div[@title id='ember738_chosen']")); // Click on sum
        clickElement(By.id("ember738_chosen")); // Click on sum


    }


}

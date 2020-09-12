import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PickBusinessTest extends BasePage{

    @BeforeClass
    public static void runOnceBeforeClass() {
        getUrl("https://buyme.co.il/search?budget=4&category=204&region=11");
    }

    @Test
    public void test01_pickBusiness(){
        // Assert url https://buyme.co.il/search?budget=4&category=204&region=11
        Assert.assertEquals("https://buyme.co.il/search?budget=4&category=204&region=11",getCurrentUrl());

        clickElement(By.id("ember950")); // Click on מחוץ לקופסה - מתנות וגאדג'טים

        sendKeysToElement(By.id("ember1242"), "400"); // Send 400 nis to price amount
        clickElement(By.xpath("//button[@class='btn btn-theme' and @data-ember-action='1243']")); // Click on לבחירה



//        clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
//        clickElement(By.xpath("//span[@class='text-btn' and @data-ember-action='1154']")); // Click on להרשמה
//
//        sendKeysToElement(By.id("ember1179"), "מיכאל"); // Send name
//        sendKeysToElement(By.id("ember1181"), Constants.MY_EMAIL); // Send email
//        sendKeysToElement(By.id("valPass"), "Abcd1efgh");  // Send password (temporary)
//        sendKeysToElement(By.id("ember1185"), "Abcd1efgh");  // Re-enter password (temporary)
//
//        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-הרשמה ל


    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Extras class contains project's extras.
 */

public class Extras extends BasePage{
    public Extras() throws Exception {
    }

    @BeforeClass
    public void runOnceBeforeClass() throws Exception {

    }

    // Login without credentials ans assert error messages
    @Test
    public void test01_assertErrorMessages() throws Exception {
        getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
        waitelementToBeClickable(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Wait until כניסה | השרמה is clickable
        clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-הרשמה ל

        Assert.assertEquals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה", getElementText(By.id("parsley-id-12"))); // Email Assert
        Assert.assertEquals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה", getElementText(By.id("parsley-id-14"))); // Email Assert
    }

    @Test
    public void test02_dotsHeightWidth() throws Exception {
        //sendKeysToElement(By.tagName("body"), "Keys.ESCAPE"); // ESCAPE to pause page loading

//        waitelementToBeClickable(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")); // Wait until yellow bounce is clickable
//        System.out.println(getElementHeight(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")));
//        System.out.println(getElementWidth(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")));
    }

    // Print the color of למי לשלוח
    @Test
    public void test03_elementColor() throws Exception {
        getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
        Login.loginWithExistingUser();

        clickElement(By.id("ember738_chosen")); // Click on sum
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='4']")); // Pick the sum

        clickElement(By.id("ember753_chosen")); // Click on region
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='2']")); // Pick the region

        clickElement(By.id("ember763_chosen")); // Click on category
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick the category

        clickElement(By.id("ember798")); // Click on "Find me a present"

        waitelementToBeClickable(By.id("ember1387")); // Wait until מתנות וגאדג'טים is clickable
        clickElement(By.id("ember1387")); // Click on מחוץ לקופסה - מתנות וגאדג'טים

        sendKeysToElement(By.id("ember1484"), "400"); // Send 400 nis to price amount
        clickElement(By.xpath("//button[@class='btn btn-theme' and @data-ember-action='1485']")); // Click on לבחירה

        System.out.println(getElementColor(By.xpath("//div[@class='step-title highlighted']"))); // Print the color of למי לשלוח

    }




}

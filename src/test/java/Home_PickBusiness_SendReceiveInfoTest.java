import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This class contains Home (pick price, region and category),
 * pick business and filling sender and receiver info.
 * Most stable locators are identified by Selenium.
 * Elements assertion is took place.
 * Class extends BasePage, which contains a bunch of popular methods, so they are reused.
 */

public class Home_PickBusiness_SendReceiveInfoTest extends BasePage{
    public Home_PickBusiness_SendReceiveInfoTest() throws Exception {
    }

    @BeforeClass
    public void runOnceBeforeClass() throws Exception {
        getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
        Login.loginWithExistingUser();
    }

    @Test
    public void test01_homeScreen() throws Exception {
        //clickElement(By.xpath("//div[@title id='ember738_chosen']")); // Click on sum
        clickElement(By.id("ember738_chosen")); // Click on sum
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='4']")); // Pick the sum

        clickElement(By.id("ember753_chosen")); // Click on region
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='2']")); // Pick the region

        clickElement(By.id("ember763_chosen")); // Click on category
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick the category

        clickElement(By.id("ember798")); // Click on "Find me a present"

        Thread.sleep(2000); // Adding sleep thread for human eye comfortability

    }

    @Test
    public void test02_pickBusiness() throws Exception {
        // Assert url https://buyme.co.il/search?budget=4&category=204&region=11
        Assert.assertEquals(GetXmlData.getData("UrlPickBusiness"),getCurrentUrl());

        waitelementToBeClickable(By.id("ember1387")); // Wait until מתנות וגאדג'טים is clickable
        clickElement(By.id("ember1387")); // Click on מחוץ לקופסה - מתנות וגאדג'טים

        sendKeysToElement(By.id("ember1484"), "400"); // Send 400 nis to price amount
        clickElement(By.xpath("//button[@class='btn btn-theme' and @data-ember-action='1485']")); // Click on לבחירה
        Thread.sleep(2000); // Adding sleep thread for human eye comfortability

    }

    @Test
    public void test03_SenderReceiverInfo() throws Exception {

        clickElement(By.xpath("//label[@class='option selected' and @data-ember-action='1597']")); // Click on למישהו אחר

        sendKeysToElement(By.id("ember1601"), "Dr. Johns"); // Enter receiver name
        //sendKeysToElement(By.id("ember1603"), "Michael"); // Enter sender name

        clickElement(By.id("ember1605_chosen")); // Click on event
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick an event

        sendKeysToElement(By.xpath("//textarea[@rows='4' and @data-parsley-group='main']"), "שנה טובה ובלי קורונה !"); // Enter blessing

        sendKeysToElement(By.id("ember1634"), "C:\\Users\\Noam\\Downloads\\ShanaTova.PNG"); // Upload picture

        clickElement(By.xpath("//label[@class='send-now' and @data-ember-action='1647']")); // Click on מיד אחרי התשלום

        clickElement(By.xpath("//button[@class='btn btn-clean btn-send-option fluid ' and @data-ember-action='1549']")); // Click on Mail
        sendKeysToElement(By.id("ember2072"), Constants.MY_EMAIL); // Enter mail address
        clickElement(By.xpath("//button[@class='btn btn-theme btn-save' and @data-ember-action='2074']")); // Click on שמירה

        Assert.assertEquals("אל Dr. Johns", getElementText(By.xpath("//div[@class='receiver']"))); // Receiver Assert
        Assert.assertEquals("ממי המתנה? Michael Khasin", getElementText(By.xpath("//div[@class='sender']"))); // Sender Assert
    }

}

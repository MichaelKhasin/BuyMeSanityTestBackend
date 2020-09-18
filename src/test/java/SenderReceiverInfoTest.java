import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SenderReceiverInfoTest extends BasePage{

    public SenderReceiverInfoTest() throws Exception {
    }

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
       // https://buyme.co.il/money/1987736
        getUrl(GetXmlData.getData("SenderReceiverInfo")); // read from data.xml  https://buyme.co.il/money/1987736
    }

    @Test
    public void test01_SenderReceiverInfo() throws Exception {
        sendKeysToElement(By.id("ember905"), "400"); // Send 400 nis to price amount
        clickElement(By.xpath("//button[@class='btn btn-theme' and @data-ember-action='906']")); // Click on לבחירה

        clickElement(By.xpath("//label[@class='option selected' and @data-ember-action='1207']")); // Click on למישהו אחר

        sendKeysToElement(By.id("ember1217"), "Dr. Johns"); // Enter receiver name
        sendKeysToElement(By.id("ember1219"), "Michael"); // Enter sender name

        clickElement(By.id("ember1221_chosen")); // Click on sum
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick an event

        sendKeysToElement(By.xpath("//textarea[@rows='4' and @data-parsley-group='main']"), "שנה טובה ובלי קורונה !"); // Enter blessing

        sendKeysToElement(By.id("ember1250"), "C:\\Users\\Noam\\Downloads\\ShanaTova.PNG"); // Upload picture

        clickElement(By.xpath("//label[@class='send-now' and @data-ember-action='1269']")); // Click on מיד אחרי התשלום

        clickElement(By.xpath("//button[@class='btn btn-clean btn-send-option fluid ' and @data-ember-action='1159']")); // Click on Mail
        sendKeysToElement(By.id("ember1695"), Constants.MY_EMAIL); // Enter mail address
        clickElement(By.xpath("//button[@class='btn btn-theme btn-save' and @data-ember-action='1697']")); // Click on שמירה

    }

    @Test
    public void test02_senderReceiverAssert() throws Exception {
        Assert.assertEquals("אל Dr. Johns", getElementText(By.xpath("//div[@class='receiver']"))); // Receiver Assert
        Assert.assertEquals("ממי המתנה? Michael", getElementText(By.xpath("//div[@class='sender']"))); // Sender Assert
    }

}

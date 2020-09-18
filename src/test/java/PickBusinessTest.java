import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PickBusinessTest extends BasePage{

    public PickBusinessTest() throws Exception {
    }

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
       // https://buyme.co.il/search?budget=4&category=204&region=11
        getUrl(GetXmlData.getData("UrlPickBusiness")); // read from data.xml  https://buyme.co.il/search?budget=4&category=204&region=11
    }

    @Test
    public void test01_pickBusiness() throws Exception {
        // Assert url https://buyme.co.il/search?budget=4&category=204&region=11
        Assert.assertEquals(GetXmlData.getData("UrlPickBusiness"),getCurrentUrl());

        clickElement(By.id("ember950")); // Click on מחוץ לקופסה - מתנות וגאדג'טים

        sendKeysToElement(By.id("ember1242"), "400"); // Send 400 nis to price amount
        clickElement(By.xpath("//button[@class='btn btn-theme' and @data-ember-action='1243']")); // Click on לבחירה

    }
}

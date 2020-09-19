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
        getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
    }

    @Test
    public void test01_assertErrorMessages() throws Exception {
        waitelementToBeClickable(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Wait until כניסה | השרמה is clickable
        clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-הרשמה ל

        Assert.assertEquals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה", getElementText(By.id("parsley-id-12"))); // Email Assert
        Assert.assertEquals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה", getElementText(By.id("parsley-id-14"))); // Email Assert
    }

    @Test
    public void test02_dotsHeightWidth() throws Exception {

        sendKeysToElement(By.tagName("body"), "Keys.ESCAPE"); // ESCAPE to pause page loading

//        waitelementToBeClickable(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")); // Wait until yellow bounce is clickable
//        System.out.println(getElementHeight(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")));
//        System.out.println(getElementWidth(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")));

    }


}

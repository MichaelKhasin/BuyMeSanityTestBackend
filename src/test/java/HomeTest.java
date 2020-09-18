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
    public HomeTest() throws Exception {
    }

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
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

    }


}

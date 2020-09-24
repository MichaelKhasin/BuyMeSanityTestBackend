import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Extras class contains project's extras.
 */

public class Extras extends BasePage{
    // create ExtentReports and attach reporter(s)
    public static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test;
    boolean scroll = false;

    public Extras() throws Exception {
    }

    @BeforeClass
    public void runOnceBeforeClass() throws Exception {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Noam\\Downloads\\Extent_Extras.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("Extent Report for RegistrationTest", "Sample description");
        // add custom system info
        extent.setSystemInfo("Environment", "IntellyJ Idea");
        extent.setSystemInfo("Development & QA", "Michael");
        test.log(Status.INFO, "Report start");

    }

    // Login without credentials ans assert error messages
    @Test
    public void test01_assertErrorMessages() throws Exception {
        getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
        waitelementToBeClickable(By.xpath("//span[contains(text(), 'כניסה')]")); // Wait until כניסה is clickable
        clickElement(By.xpath("//span[contains(text(), 'כניסה')]")); // Click on כניסה
        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-כניסה ל

        Assert.assertEquals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה", getElementText(By.id("parsley-id-12"))); // Email Assert
        Assert.assertEquals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה", getElementText(By.id("parsley-id-14"))); // Email Assert
    }

    @Test
    public void test02_dotsHeightWidth() throws Exception {
        getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
        stopLoadingPage();
//        reloadUrl();
//        actionPerform("Keys.ESCAPE");
        //sendKeysToElement(By.xpath("/html/body"), "Keys.ESCAPE"); // ESCAPE to pause page loading

//        waitelementToBeClickable(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")); // Wait until yellow bounce is clickable
//        System.out.println(getElementHeight(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")));
//        System.out.println(getElementWidth(By.xpath("//*[@id=\"app-loading-img\"]/div/div[3]")));
    }

    // Print the color of למי לשלוח , Scroll to the bottom, printscreen and add to Report
    @Test
    public void test03_elementColor() throws Exception {
        getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
        Login.loginWithExistingUser();

        clickElement(By.id("ember776_chosen")); // Click on sum
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='4']")); // Pick the sum

        clickElement(By.id("ember791_chosen")); // Click on region
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='2']")); // Pick the region

        clickElement(By.id("ember801_chosen")); // Click on category
        clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick the category

        clickElement(By.xpath("//a[@rel='nofollow' and @class='ui-btn search ember-view']")); // Click on "Find me a present"

        waitelementToBeClickable(By.xpath("//div[@class='thumbnail' and @data-lazy='background-image: url(\"https://buyme.co.il/files/siteCategoryImg1987736.jpg?1517395490521\")']")); // Wait until מתנות וגאדג'טים is clickable
        clickElement(By.xpath("//div[@class='thumbnail' and @data-lazy='background-image: url(\"https://buyme.co.il/files/siteCategoryImg1987736.jpg?1517395490521\")']")); // Click on מחוץ לקופסה - מתנות וגאדג'טים

        sendKeysToElement(By.xpath("//input[@placeholder='מה הסכום?']"), "400"); // Send 400 nis to price amount
        clickElement(By.xpath("//button[@class='btn btn-theme' and contains(text(), 'לבחירה')]")); // Click on לבחירה

        System.out.println(getElementColor(By.xpath("//div[@class='step-title highlighted']"))); // Print the color of למי לשלוח


        scroll = false;
        try {
            scrolltoElement(By.xpath("//input[@placeholder='המייל שלך']"));
            scroll = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Scroll is not successful" + e.getMessage());
            scroll = false;

        } finally {
            if (scroll) {
                test.log(Status.PASS, "Scroll is successful");
            }
        }
    }

    // Extent Report flush
    @AfterClass
    public void afterClass() throws Exception {
        extent.flush();
    }


}

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This class contains Registration test.
 * Most stable locators are identified by Selenium.
 * Elements assertion is took place.
 * Class extends BasePage, which contains a bunch of popular methods, so they are reused.
 */

public class RegistrationTest extends BasePage{
    // create ExtentReports and attach reporter(s)
    public static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test;
    boolean pageOpened = false;
    boolean clickElement = false;
    boolean sendKeys = false;

    public RegistrationTest() throws Exception {
    }

    @BeforeClass
    public void runOnceBeforeClass() throws Exception {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Noam\\Downloads\\Extent_RegistrationTest.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("Extent Report for RegistrationTest", "Sample description");
        // add custom system info
        extent.setSystemInfo("Environment", "IntellyJ Idea");
        extent.setSystemInfo("Development & QA", "Michael");
        test.log(Status.INFO, "Report start");


        //getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
        pageOpened = false;
        try {
            getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
            pageOpened = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "buyme.co.il page was not found  " + e.getMessage());
            pageOpened = false;

        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "Open webpage:  " + "Webpage opened successfully");
            }
        }

    }

    @Test
    public void test01_registration() throws Exception {

        Thread.sleep(2000); // Adding sleep thread for human eye comfortability

        waitelementToBeClickable(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Wait until כניסה | השרמה is clickable

        //clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
        clickElement = false;
        try {
            clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element כניסה | השרמה is not clickable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element כניסה | השרמה clicked successfully");
            }
        }


        //clickElement(By.xpath("//span[@class='text-btn' and @data-ember-action='1154']")); // Click on להרשמה
        clickElement = false;
        try {
            clickElement(By.xpath("//span[@class='text-btn' and @data-ember-action='1154']")); // Click on להרשמה
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element להרשמה is not clickable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element להרשמה clicked successfully");
            }
        }

        //sendKeysToElement(By.id("ember1179"), "מיכאל"); // Send name
        sendKeys = false;
        try {
            sendKeysToElement(By.id("ember1179"), "מיכאל"); // Send name
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'Send name'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'Send name'");
            }
        }

        //sendKeysToElement(By.id("ember1181"), Constants.MY_EMAIL); // Send email
        sendKeys = false;
        try {
            sendKeysToElement(By.id("ember1181"), Constants.MY_EMAIL); // Send email
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'Send mail'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'Send mail'");
            }
        }

        //sendKeysToElement(By.id("valPass"), "Abcd1efgh");  // Send password (temporary)
        sendKeys = false;
        try {
            sendKeysToElement(By.id("valPass"), "Abcd1efgh");  // Send password (temporary)
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'Send password'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'Send password'");
            }
        }

        //sendKeysToElement(By.id("ember1185"), "Abcd1efgh");  // Re-enter password (temporary)
        sendKeys = false;
        try {
            sendKeysToElement(By.id("ember1185"), "Abcd1efgh");  // Re-enter password (temporary)
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'Re-enter password'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'Re-enter password'");
            }
        }

        //clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-הרשמה ל
        clickElement = false;
        try {
            clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-הרשמה ל
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element BUYME-הרשמה ל is not clickable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element BUYME-הרשמה ל clicked successfully");
            }
        }

        Thread.sleep(2000); // Adding sleep thread for human eye comfortability

    }

    @Test
    public void test02_assertRegistration() throws Exception {
        // Registration error in case mail already exists - Assertion if "error message" element displayed:
        isDisplayedElement(By.xpath("//div[@class='login-error']"));

        isDisplayedElement(By.id("ember1179")); // Assertion if name element displayed
        isDisplayedElement(By.id("ember1181")); // Assertion if email element displayed
        isDisplayedElement(By.id("valPass")); // Assertion if password element displayed
        isDisplayedElement(By.id("ember1185")); // Assertion if re-enter password element displayed

    }

    @AfterClass
    public void afterClass() throws Exception {
        extent.flush();
    }


}

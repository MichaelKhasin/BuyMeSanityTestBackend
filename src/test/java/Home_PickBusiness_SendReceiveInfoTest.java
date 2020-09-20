import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

    // create ExtentReports and attach reporter(s)
    public static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test;
    boolean pageOpened = false;
    boolean clickElement = false;
    boolean sendKeys = false;
    public Home_PickBusiness_SendReceiveInfoTest() throws Exception {
    }

    @BeforeClass
    public void runOnceBeforeClass() throws Exception {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Noam\\Downloads\\Extent_Home_PickBusiness_SendReceiveInfoTest.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("Extent Report for Home_PickBusiness_SendReceiveInfoTest", "Sample description");
        // add custom system info
        extent.setSystemInfo("Environment", "IntellyJ Idea");
        extent.setSystemInfo("Development & QA", "Michael");
        test.log(Status.INFO, "Report start");


        // getUrl(GetXmlData.getData("UrlRegistration")); // read from data.xml  https://buyme.co.il
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


        Login.loginWithExistingUser();
    }

    @Test
    public void test01_homeScreen() throws Exception {
        // clickElement(By.id("ember738_chosen")); // Click on sum
        clickElement = false;
        try {
            clickElement(By.id("ember738_chosen")); // Click on sum
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element sum is not clickable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element sum clicked successfully");
            }
        }


        //clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='4']")); // Pick the sum 300-499
        clickElement = false;
        try {
            clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='4']")); // Pick the sum 300-499
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Drop down Element 300-499 is not reachable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Drop down Element:  " + "Element 300-499 picked successfully");
            }
        }

        //clickElement(By.id("ember753_chosen")); // Click on region
        clickElement = false;
        try {
            clickElement(By.id("ember753_chosen")); // Click on region
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element region is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element region clicked successfully");
            }
        }

        //clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='2']")); // Pick the region merkaz
        clickElement = false;
        try {
            clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='2']")); // Pick the region merkaz
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Drop down Element merkaz is not reachable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Drop down Element:  " + "Element merkaz picked successfully");
            }
        }

        //clickElement(By.id("ember763_chosen")); // Click on category
        clickElement = false;
        try {
            clickElement(By.id("ember763_chosen")); // Click on category
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element category is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element category clicked successfully");
            }
        }

        //clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick the category מתנות עד הבית
        clickElement = false;
        try {
            clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick the category מתנות עד הבית
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Drop down Element מתנות עד הבית is not reachable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Drop down Element:  " + "Element מתנות עד הבית picked successfully");
            }
        }

        //clickElement(By.id("ember798")); // Click on "Find me a present"
        clickElement = false;
        try {
            clickElement(By.id("ember798")); // Click on "Find me a present"
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element Find me a present is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element Find me a present clicked successfully");
            }
        }


        Thread.sleep(2000); // Adding sleep thread for human eye comfortability

    }

    @Test
    public void test02_pickBusiness() throws Exception {
        // Assert url https://buyme.co.il/search?budget=4&category=204&region=11
        Assert.assertEquals(GetXmlData.getData("UrlPickBusiness"),getCurrentUrl());

        waitelementToBeClickable(By.id("ember1387")); // Wait until מתנות וגאדג'טים is clickable

        //clickElement(By.id("ember1387")); // Click on מחוץ לקופסה - מתנות וגאדג'טים
        clickElement = false;
        try {
            clickElement(By.id("ember1387")); // Click on מחוץ לקופסה - מתנות וגאדג'טים
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element מחוץ לקופסה - מתנות וגאדג'טים is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element מחוץ לקופסה - מתנות וגאדג'טים clicked successfully");
            }
        }

        //sendKeysToElement(By.id("ember1484"), "400"); // Send 400 nis to price amount
        sendKeys = false;
        try {
            sendKeysToElement(By.id("ember1484"), "400"); // Send 400 nis to price amount
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'price amount'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'price amount'");
            }
        }

        //clickElement(By.xpath("//button[@class='btn btn-theme' and @data-ember-action='1485']")); // Click on לבחירה
        clickElement = false;
        try {
            clickElement(By.xpath("//button[@class='btn btn-theme' and @data-ember-action='1485']")); // Click on לבחירה
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element לבחירה is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element לבחירה clicked successfully");
            }
        }

        Thread.sleep(2000); // Adding sleep thread for human eye comfortability

    }

    @Test
    public void test03_SenderReceiverInfo() throws Exception {

        // clickElement(By.xpath("//label[@class='option selected' and @data-ember-action='1597']")); // Click on למישהו אחר
        clickElement = false;
        try {
            clickElement(By.xpath("//label[@class='option selected' and @data-ember-action='1597']")); // Click on למישהו אחר
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element למישהו אחר is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element למישהו אחר clicked successfully");
            }
        }


        //sendKeysToElement(By.id("ember1601"), "Dr. Johns"); // Enter receiver name
        sendKeys = false;
        try {
            sendKeysToElement(By.id("ember1601"), "Dr. Johns"); // Enter receiver name
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'receiver name'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'receiver name'");
            }
        }

        //sendKeysToElement(By.id("ember1603"), "Michael"); // Enter sender name

        //clickElement(By.id("ember1605_chosen")); // Click on event
        clickElement = false;
        try {
            clickElement(By.id("ember1605_chosen")); // Click on event
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element event is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element event clicked successfully");
            }
        }

        //clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick an event
        clickElement = false;
        try {
            clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick an event
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Drop down Element event is not reachable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Drop down Element:  " + "Element event picked successfully");
            }
        }

        //sendKeysToElement(By.xpath("//textarea[@rows='4' and @data-parsley-group='main']"), "שנה טובה ובלי קורונה !"); // Enter blessing
        sendKeys = false;
        try {
            sendKeysToElement(By.xpath("//textarea[@rows='4' and @data-parsley-group='main']"), "שנה טובה ובלי קורונה !"); // Enter blessing
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'blessing'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'blessing'");
            }
        }

        //sendKeysToElement(By.id("ember1634"), "C:\\Users\\Noam\\Downloads\\ShanaTova.PNG"); // Upload picture
        sendKeys = false;
        try {
            sendKeysToElement(By.id("ember1634"), "C:\\Users\\Noam\\Downloads\\ShanaTova.PNG"); // Upload picture
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'Upload picture'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'Upload picture'");
            }
        }


        //clickElement(By.xpath("//label[@class='send-now' and @data-ember-action='1647']")); // Click on מיד אחרי התשלום
        clickElement = false;
        try {
            clickElement(By.xpath("//label[@class='send-now' and @data-ember-action='1647']")); // Click on מיד אחרי התשלום
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element מיד אחרי התשלום is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element מיד אחרי התשלום clicked successfully");
            }
        }


        //clickElement(By.xpath("//button[@class='btn btn-clean btn-send-option fluid ' and @data-ember-action='1549']")); // Click on Mail
        clickElement = false;
        try {
            clickElement(By.xpath("//button[@class='btn btn-clean btn-send-option fluid ' and @data-ember-action='1549']")); // Click on Mail
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element Mail is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element Mail clicked successfully");
            }
        }

        //sendKeysToElement(By.id("ember2076"), Constants.MY_EMAIL); // Enter mail address
        sendKeys = false;
        try {
            sendKeysToElement(By.id("ember2076"), Constants.MY_EMAIL); // Enter mail address
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'mail address'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'mail address'");
            }
        }

        //clickElement(By.xpath("//button[@class='btn btn-theme btn-save' and @data-ember-action='2078']")); // Click on שמירה
        clickElement = false;
        try {
            clickElement(By.xpath("//button[@class='btn btn-theme btn-save' and @data-ember-action='2078']")); // Click on שמירה
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Noam\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element שמירה is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element Mail clicked successfully");
            }
        }

        Assert.assertEquals("אל Dr. Johns", getElementText(By.xpath("//div[@class='receiver']"))); // Receiver Assert
        Assert.assertEquals("ממי המתנה? Michael Khasin", getElementText(By.xpath("//div[@class='sender']"))); // Sender Assert
    }

    @AfterClass
    public void afterClass() throws Exception {
        extent.flush();
    }

}

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
 * This class contains Home (pick price, region and category) from REST API
 * pick business and filling sender and receiver info.
 * Most stable locators are identified by Selenium.
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
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Misha\\Downloads\\Extent_Home_PickBusiness_SendReceiveInfoTest.html");
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
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
        RestApiTest.get_values(); // Call function to get indexes values from REST API
    }

    @Test
    public void test01_homeScreen() throws Exception {
        // Click on sum
        // clickElement(By.xpath("//div[@class='chosen-container chosen-container-single form-control dib search-chosen ember-view ember-chosenselect form-control chosen-rtl chosen-rtl chosen-container-single-nosearch']//a[@class='chosen-single' and @tabindex='-1']//span[contains(text(), 'סכום')]")); // Click on sum
        clickElement = false;
        try {
            clickElement(By.xpath("//div[@class='chosen-container chosen-container-single form-control dib search-chosen ember-view ember-chosenselect form-control chosen-rtl chosen-rtl chosen-container-single-nosearch']//a[@class='chosen-single' and @tabindex='-1']//span[contains(text(), 'סכום')]")); // Click on sum
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
            //clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='4']")); // Pick the sum 300-499

            // Get index value from REST API
            clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='" + RestApiTest.amount_index + "']")); // Pick the sum, get value from REST API
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Drop down Element 300-499 is not reachable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Drop down Element:  " + "Element 300-499 picked successfully");
            }
        }

        // Click on region
        // clickElement(By.xpath("//div[@class='chosen-container chosen-container-single form-control dib search-chosen ember-view ember-chosenselect form-control chosen-rtl chosen-rtl chosen-container-single-nosearch']//a[@class='chosen-single' and @tabindex='-1']//span[contains(text(), 'אזור')]")); // Click on region
        clickElement = false;
        try {
            clickElement(By.xpath("//div[@class='chosen-container chosen-container-single form-control dib search-chosen ember-view ember-chosenselect form-control chosen-rtl chosen-rtl chosen-container-single-nosearch']//a[@class='chosen-single' and @tabindex='-1']//span[contains(text(), 'אזור')]")); // Click on region
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
            // clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='2']")); // Pick the region merkaz
            clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='" + RestApiTest.region_index + "']")); // Pick the region from REST API
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Drop down Element merkaz is not reachable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Drop down Element:  " + "Element merkaz picked successfully");
            }
        }

        // Click on category
        // clickElement(By.xpath("//div[@class='chosen-container chosen-container-single form-control dib search-chosen ember-view ember-chosenselect form-control chosen-rtl chosen-rtl']//a[@class='chosen-single' and @tabindex='-1']//span[contains(text(), 'קטגוריה')]")); // Click on category
        clickElement = false;
        try {
            clickElement(By.xpath("//div[@class='chosen-container chosen-container-single form-control dib search-chosen ember-view ember-chosenselect form-control chosen-rtl chosen-rtl']//a[@class='chosen-single' and @tabindex='-1']//span[contains(text(), 'קטגוריה')]")); // Click on category
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
            //clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='1']")); // Pick the category מתנות עד הבית
            clickElement(By.xpath("//li[@class='active-result' and @data-option-array-index='" + RestApiTest.category_index + "']")); // Pick the category from REST API
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Drop down Element מתנות עד הבית is not reachable " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Drop down Element:  " + "Element מתנות עד הבית picked successfully");
            }
        }

        //clickElement(By.xpath("//a[@rel='nofollow' and @class='ui-btn search ember-view']")); // Click on "Find me a present"
        clickElement = false;
        try {
            clickElement(By.xpath("//a[@rel='nofollow' and @class='ui-btn search ember-view']")); // Click on "Find me a present"
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
//        // Assert url https://buyme.co.il/search?budget=4&category=204&region=11
//        //Assert.assertEquals(GetXmlData.getData("UrlPickBusiness"),getCurrentUrl());
//
//        waitelementToBeClickable(By.xpath("//div[@class='thumbnail' and @data-lazy='background-image: url(\"https://buyme.co.il/files/siteCategoryImg1987736.jpg?1517395490521\")']")); // Wait until מתנות וגאדג'טים is clickable
//
//        //clickElement(By.xpath("//div[@class='thumbnail' and @data-lazy='background-image: url(\"https://buyme.co.il/files/siteCategoryImg1987736.jpg?1517395490521\")']")); // Click on מחוץ לקופסה - מתנות וגאדג'טים
//        clickElement = false;
//        try {
//            clickElement(By.xpath("//div[@class='thumbnail' and @data-lazy='background-image: url(\"https://buyme.co.il/files/siteCategoryImg1987736.jpg?1517395490521\")']")); // Click on מחוץ לקופסה - מתנות וגאדג'טים
//            clickElement = true;
//            String timeNow = String.valueOf(System.currentTimeMillis());
//            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            test.log(Status.FAIL, "Element מחוץ לקופסה - מתנות וגאדג'טים is not clickable  " + e.getMessage());
//            clickElement = false;
//
//        } finally {
//            if (clickElement) {
//                test.log(Status.PASS, "Click Element:  " + "Element מחוץ לקופסה - מתנות וגאדג'טים clicked successfully");
//            }
//        }


         waitelementToBeClickable(By.xpath("//li[@gtm='בלי יתרה-BUYME MULTI']")); // Wait until Buyme Multi is clickable

        //clickElement(By.xpath("//li[@gtm='בלי יתרה-BUYME MULTI']")); // Click on Buyme Multi
        clickElement = false;
        try {
            clickElement(By.xpath("//li[@gtm='בלי יתרה-BUYME MULTI']")); // Click on Buyme Multi
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element Buyme Multi is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element Buyme Multi clicked successfully");
            }
        }



        //sendKeysToElement(By.xpath("//input[@placeholder='מה הסכום?']"), "400"); // Send 400 nis to price amount
        sendKeys = false;
        try {
            //sendKeysToElement(By.xpath("//input[@placeholder='מה הסכום?']"), "400"); // Send 400 nis to price amount
            sendKeysToElement(By.xpath("//input[@placeholder='מה הסכום?']"), RestApiTest.gift_amount); // Send "gift_amount" nis to price amount from REST API
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
            clickElement(By.xpath("//button[@class='btn btn-theme' and contains(text(), 'לבחירה')]")); // Click on לבחירה
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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

        // clickElement(By.xpath("//span[@class='text' and contains(text(), 'למישהו אחר')]")); // Click on למישהו אחר
        clickElement = false;
        try {
            clickElement(By.xpath("//span[@class='text' and contains(text(), 'למישהו אחר')]")); // Click on למישהו אחר
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element למישהו אחר is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element למישהו אחר clicked successfully");
            }
        }


        //sendKeysToElement(By.xpath("//input[@type='text' and @data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']"), "Dr. Johns"); // Enter receiver name
        sendKeys = false;
        try {
            sendKeysToElement(By.xpath("//input[@type='text' and @data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']"), "Dr. Johns"); // Enter receiver name
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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

        //clickElement(By.xpath("//span[contains(text(), 'לאיזה אירוע?')]")); // Click on event
        clickElement = false;
        try {
            clickElement(By.xpath("//span[contains(text(), 'לאיזה אירוע?')]")); // Click on event
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'blessing'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'blessing'");
            }
        }

        //sendKeysToElement(By.xpath("//input[@accept='image/*' and @name='fileUpload']"), "C:\\Users\\Misha\\Downloads\\ShanaTova.PNG"); // Upload picture
        sendKeys = false;
        try {
            sendKeysToElement(By.xpath("//input[@accept='image/*' and @name='fileUpload']"), "C:\\Users\\Misha\\Downloads\\ShanaTova.PNG"); // Upload picture
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'Upload picture'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'Upload picture'");
            }
        }


        //clickElement(By.xpath("//label[@class='send-now' and contains(text(), 'מיד אחרי התשלום')]")); // Click on מיד אחרי התשלום
        clickElement = false;
        try {
            clickElement(By.xpath("//label[@class='send-now' and contains(text(), 'מיד אחרי התשלום')]")); // Click on מיד אחרי התשלום
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element מיד אחרי התשלום is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element מיד אחרי התשלום clicked successfully");
            }
        }


        //clickElement(By.xpath("//span[@class='btn-text' and contains(text(), 'במייל')]")); // Click on Mail
        clickElement = false;
        try {
            clickElement(By.xpath("//span[@class='btn-text' and contains(text(), 'במייל')]")); // Click on Mail
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Element Mail is not clickable  " + e.getMessage());
            clickElement = false;

        } finally {
            if (clickElement) {
                test.log(Status.PASS, "Click Element:  " + "Element Mail clicked successfully");
            }
        }

        //sendKeysToElement(By.xpath("//input[@data-parsley-type='email' and @placeholder='כתובת המייל של מקבל/ת המתנה']"), Constants.MY_EMAIL); // Enter mail address
        sendKeys = false;
        try {
            //sendKeysToElement(By.xpath("//input[@data-parsley-type='email' and @placeholder='כתובת המייל של מקבל/ת המתנה']"), Constants.MY_EMAIL); // Enter mail address
            sendKeysToElement(By.xpath("//input[@data-parsley-type='email' and @class='form-control input-theme input-mail ember-view ember-text-field']"), Constants.MY_EMAIL); // Enter mail address
            sendKeys = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to sendKeys to element 'mail address'" + e.getMessage());
            sendKeys = false;

        } finally {
            if (sendKeys) {
                test.log(Status.PASS, "SendKeys:  " + "Successfully sendKeys to element 'mail address'");
            }
        }

        //clickElement(By.xpath("//button[@class='btn btn-theme btn-save' and contains(text(), 'שמירה')]")) // Click on שמירה
        clickElement = false;
        try {
            clickElement(By.xpath("//button[@class='btn btn-theme btn-save' and contains(text(), 'שמירה')]")); // Click on שמירה
            clickElement = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Misha\\Downloads\\" + timeNow)).build());

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

    // Extent Report flush
    @AfterClass
    public void afterClass() throws Exception {
        extent.flush();
    }

}

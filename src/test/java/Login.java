import org.openqa.selenium.By;

/**
 * This class contains login to the https://buyme.co.il site.
 * Most stable locators are identified by Selenium.
 * Created as separate class.
 * Class extends BasePage, which contains a bunch of popular methods, so they are reused.
 */

public class Login extends BasePage {
    public Login() throws Exception {
    }

    public static void loginWithExistingUser() throws Exception {
        // Login to BuyMe with existing user
        Thread.sleep(2000); // Adding sleep thread for human eye comfortability
        waitelementToBeClickable(By.xpath("//li[@class='solid' and @data-ember-action='735']")); // Wait until כניסה | השרמה is clickable
        clickElement(By.xpath("//span[@class='seperator-link']")); // Click on כניסה
        sendKeysToElement(By.xpath("//input[@placeholder='מייל']"), Constants.MY_EMAIL); // Send email
        sendKeysToElement(By.xpath("//input[@placeholder='סיסמה']"), Constants.MY_PASSWORD);  // Send password
        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-כניסה ל
    }
}

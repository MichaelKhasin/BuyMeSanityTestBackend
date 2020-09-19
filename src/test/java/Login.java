import org.openqa.selenium.By;

public class Login extends BasePage {
    public Login() throws Exception {
    }

    public static void loginWithExistingUser() throws Exception {
        // Login to BuyMe with existing user
        Thread.sleep(2000); // Adding sleep thread for human eye comfortability
        waitelementToBeClickable(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Wait until כניסה | השרמה is clickable
        clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
        sendKeysToElement(By.id("ember1165"), Constants.MY_EMAIL); // Send email
        sendKeysToElement(By.id("ember1167"), Constants.MY_PASSWORD);  // Send password
        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-כניסה ל
    }
}

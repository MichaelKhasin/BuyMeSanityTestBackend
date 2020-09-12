import org.openqa.selenium.By;

public class Login extends BasePage {
    public static void loginWithExistingUser() {
        // Login to BuyMe with existing user
        clickElement(By.xpath("//li[@class='solid' and @data-ember-action='697']")); // Click on כניסה | השרמה
        sendKeysToElement(By.id("ember1165"), Constants.MY_EMAIL); // Send email
        sendKeysToElement(By.id("ember1167"), Constants.MY_PASSWORD);  // Send password
        clickElement(By.xpath("//button[@type='submit' and @class='ui-btn orange large']")); // Click on BUYME-כניסה ל
    }
}

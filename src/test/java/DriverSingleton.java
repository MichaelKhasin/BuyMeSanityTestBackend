import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

/**
 * Webderiver instance instantiated by Singleton design pattern.
 */

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {

            if (driver == null) {
                String type = GetXmlData.getData("browserType");
                if (type.equals("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "e:\\QA_Automation_Java\\chromedriver_win32\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("-incognito");
                    driver = new ChromeDriver(options);

                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            }


        return driver;
    }
}

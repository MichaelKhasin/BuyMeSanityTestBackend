import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {
        if(driver == null){
            String type = GetXmlData.getData("browserType");
            if(type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "E:\\QA_Automation_Java\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}

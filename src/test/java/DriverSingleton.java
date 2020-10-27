import com.mysql.cj.exceptions.UnableToConnectException;
import com.mysql.cj.exceptions.WrongArgumentException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLSyntaxErrorException;
import java.util.concurrent.TimeUnit;

/**
 * Webdriver instance instantiated by Singleton design pattern.
 * Browser type is fetched from the DB.
 * In case the DB is not available, Browser type taken from data.xml
 */

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {

            if (driver == null) {
                String type = null;
                try {
                    type = DBActions.selectBrowser();
                } catch (SQLException | NumberFormatException | WrongArgumentException | UnableToConnectException e) { // Catch exceptions in case DB is unavailable
                        e.printStackTrace();
                    type = GetXmlData.getData("browserType"); // In case DB is unavailable, take browser type from data.xml
                }
                catch (NullPointerException e) { // Catch exceptions in case DB is unavailable
                    e.printStackTrace();
                    type = GetXmlData.getData("browserType"); // In case DB is unavailable, take browser type from data.xml
                }
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

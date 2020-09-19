import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Report {

    // create ExtentReports and attach reporter(s)
    public static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test;

    @Test
    public static void test01_reportBase() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Noam\\Downloads\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("BuyMeSanityTest", "Sample description");
        // add custom system info
        extent.setSystemInfo("Environment", "IntellyJ Idea");
        extent.setSystemInfo("Development & QA", "Michael");
        test.log(Status.INFO, "Report start");

    }


    @AfterClass
    public static void extentFlush() {
        //test.log(Status.INFO, "@After test " + "After test method");
        // build and flush report
        extent.flush();
    }


}

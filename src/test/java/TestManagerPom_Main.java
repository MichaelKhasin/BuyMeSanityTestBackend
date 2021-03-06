import org.testng.annotations.Test;


/**
 * BuyMe Test Sanity - Backend.
 * Software that testing site https://buyme.co.il including reading/writing from/to DB
 * Working with REST API and receiving Gift elements from there
 * Contains of 4 steps: Registration, Home (pick price, region and category),
 * pick business and finally filling sending and received info.
 * This specific class is the Main POM class, kind of "test Manager,
 * which instantiating the tests and their order.
 * Webderiver instance instantiated by Singleton design pattern.
 * BasePage class is used & contains a bunch of popular methods, so they are reused.
 * Tests are divided into Registration separate test and Home / pick business / sender and receiver info.
 * Constants class contains repeatable variables.
 * Extent report is used to reflect each test status.
 */

public class TestManagerPom_Main {
    public static int testID;

    @Test
    public void test01_registration() throws Exception {
        RegistrationTest registrationTest = new RegistrationTest();
        registrationTest.runOnceBeforeClass();
        registrationTest.test01_registration();
        registrationTest.test02_assertRegistration();
        registrationTest.afterClass();

        testID=1;
        DBActions.writeTestResultsToDB_Results_table(testID);
        DBActions.writeTestResultsToDB_Results_Datetime_table(testID);

    }

    @Test
    public void test02_Home_PickBusiness_SendReceiveInfo() throws Exception {
        Home_PickBusiness_SendReceiveInfoTest home_PickBusiness_SendReceiveInfoTest = new Home_PickBusiness_SendReceiveInfoTest();
        home_PickBusiness_SendReceiveInfoTest.runOnceBeforeClass();
        home_PickBusiness_SendReceiveInfoTest.test01_homeScreen();
        home_PickBusiness_SendReceiveInfoTest.test02_pickBusiness();
        home_PickBusiness_SendReceiveInfoTest.test03_SenderReceiverInfo();
        home_PickBusiness_SendReceiveInfoTest.afterClass();

        testID=2;
        DBActions.writeTestResultsToDB_Results_table(testID);
        DBActions.writeTestResultsToDB_Results_Datetime_table(testID);

        DBSingleton.con.close();
    }




}

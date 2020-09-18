import org.testng.annotations.Test;

public class TestManagerPom {

    @Test
    public void test01_registration() throws Exception {
        RegistrationTest registrationTest = new RegistrationTest();
        registrationTest.runOnceBeforeClass();
        registrationTest.test01_registration();
        registrationTest.test02_assertRegistration();
        registrationTest.afterClass();
    }

    @Test
    public void test02_home() throws Exception {
        HomeTest homeTest = new HomeTest();
        homeTest.runOnceBeforeClass();
        homeTest.test01_homeScreen();
        homeTest.afterClass();
    }

    @Test
    public void test03_pickBusiness() throws Exception {
        PickBusinessTest pickBusinessTest = new PickBusinessTest();
        pickBusinessTest.runOnceBeforeClass();
        pickBusinessTest.test01_pickBusiness();
        pickBusinessTest.afterClass();
    }

    @Test
    public void test04_SenderReceiverInfo() throws Exception {
        SenderReceiverInfoTest senderReceiverInfoTest = new SenderReceiverInfoTest();
        senderReceiverInfoTest.runOnceBeforeClass();
        senderReceiverInfoTest.test01_SenderReceiverInfo();
        senderReceiverInfoTest.test02_senderReceiverAssert();
        senderReceiverInfoTest.afterClass();
    }


}

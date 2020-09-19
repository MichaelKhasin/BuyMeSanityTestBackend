import org.testng.annotations.Test;

public class TestManagerPom_Main {

    @Test
    public void test01_registration() throws Exception {
        RegistrationTest registrationTest = new RegistrationTest();
        registrationTest.runOnceBeforeClass();
        registrationTest.test01_registration();
        registrationTest.test02_assertRegistration();
    }

    @Test
    public void test02_Home_PickBusiness_SendReceiveInfo() throws Exception {
        Home_PickBusiness_SendReceiveInfoTest home_PickBusiness_SendReceiveInfoTest = new Home_PickBusiness_SendReceiveInfoTest();
        home_PickBusiness_SendReceiveInfoTest.runOnceBeforeClass();
        home_PickBusiness_SendReceiveInfoTest.test01_homeScreen();
        home_PickBusiness_SendReceiveInfoTest.test02_pickBusiness();
        home_PickBusiness_SendReceiveInfoTest.test03_SenderReceiverInfo();
    }




}

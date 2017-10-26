import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction08 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction08() {
        getHomePage()
                .enterTextIntoSignUpToReceiveInputElement()
                .clickArrowButton().checkAlertAppearance()
                .checkAlertTextMessage("Invalid email address.");
    }

    @After
    public void after() {
        closeBrowser();
    }
}

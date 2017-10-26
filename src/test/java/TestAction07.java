import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction07 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction07() {
        getHomePage()
                .clickArrowButton()
                .checkAlertAppearance()
                .checkAlertTextMessage("Please enter email address");
    }

    @After
    public void after() {
        closeBrowser();
    }
}

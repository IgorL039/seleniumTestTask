import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction12 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction12() {
        getHomePage()
                .clickInstitutionElement()
                .SwitchToNewOpenedTab()
                .checkPageUrl();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

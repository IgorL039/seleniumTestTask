import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction02 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction02() {
        getHomePage()
                .checkNumberOfResourcesSubHeaderLinks()
                .checkResourcesSubHeaderLinksAreDisplayed()
                .checkResourcesSubHeaderLinksHaveText();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

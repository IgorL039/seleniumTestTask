import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction01 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction01() {
        getHomePage().checkTopMenuLinksAreDisplayed().checkTopMenuLinksHaveText();
    }

    @After
    public void after() {
        closeBrowser();
    }
}


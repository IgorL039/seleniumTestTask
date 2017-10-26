import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction04 extends CommonTestMethods {
    @Before
    public void before() {
        openStudentSectionHome();
    }

    @Test
    public void TestAction04() {
        getStudentSectionHomePage().checkNumberOfResourcesForMenuLinks().checkResourcesForMenuLinksAreDisplayed();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

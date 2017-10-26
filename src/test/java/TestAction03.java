import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction03 extends CommonTestMethods {
    @Before
    public void before() {
        openStudentSectionHome();
    }

    @Test
    public void TestAction03() {
        getStudentSectionHomePage()
                .checkStudentsHeaderIsDisplayed()
                .checkStudentsHeaderHasText();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

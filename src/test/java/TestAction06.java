import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction06 extends CommonTestMethods {
    @Before
    public void before() {
        openStudentSectionHome();
    }

    @Test
    public void TestAction06() {
        getStudentSectionHomePage().clickHomeElement();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

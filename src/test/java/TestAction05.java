import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction05 extends CommonTestMethods {
    @Before
    public void before() {
        openStudentSectionHome();
    }

    @Test
    public void TestAction05() {
        getStudentSectionHomePage()
                .checkStudentElementStyle()
                .checkStudentElementIsNotClickable();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction11 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction11() {
        getHomePage()
                .clickHomeElement();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

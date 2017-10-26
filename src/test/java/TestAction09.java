import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction09 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction09() {
        getHomePage()
                .enterTextIntoSearchInputElement()
                .clickLoupeButton()
                .checkItemListAppearance();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

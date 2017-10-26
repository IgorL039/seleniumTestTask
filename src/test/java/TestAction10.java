import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAction10 extends CommonTestMethods {
    @Before
    public void before() {
        openHome();
    }

    @Test
    public void TestAction10() {
        getHomePage().enterTextIntoSearchInputElement().clickLoupeButton().checkItemListAppearance().checkRandomItemPageHeader();
    }

    @After
    public void after() {
        closeBrowser();
    }
}

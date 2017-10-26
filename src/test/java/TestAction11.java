import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAction11 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/";
    private static final String HOME_ELEMENT_XPATH = "//div[@id='links-site']/ul/li/a[contains(., 'Home')]";
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void TestAction11() {
        //Click “Home” link at the top navigation menu
        driver.findElement(By.xpath(HOME_ELEMENT_XPATH)).click();
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestAction07 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/";
    private static final String BUTTON_ELEMENT_XPATH = "//button[@id='id31']";
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void TestAction07() {
        //Find “Sign up to receive Wiley updates” line and input field next to it. Do not enter anything and click arrow button
        driver.findElement(By.xpath(BUTTON_ELEMENT_XPATH)).click();
        //Check that alert appeared
        Alert alert = driver.switchTo().alert();
        //Check that alert text is “Please enter email address”
        assertEquals("Please enter email address", alert.getText());
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

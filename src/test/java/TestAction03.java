import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAction03 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/Section/id-404702.html";
    private static final String STUDENTS_HEADER_XPATH = "//div[@id='page-title']/h1";
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void TestAction03() {
        //Check that http://www.wiley.com/WileyCDA/Section/id-404702.html url is opened
        WebElement studentsHeader = driver.findElement(By.xpath(STUDENTS_HEADER_XPATH));
        //Check that “Students” header is displayed
        checkItemIsDisplayed(studentsHeader);
        assertEquals("Students", studentsHeader.getText());
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }

    private void checkItemIsDisplayed(WebElement studentsHeader) {
        assertTrue("Header " + studentsHeader.getText() + " is not displayed", studentsHeader.isDisplayed());
    }
}

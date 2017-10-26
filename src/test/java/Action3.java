import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class Action3 {
    private static final String STUDENTS_HEADER_X_PATH = "//div[@id='page-title']/h1";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        return driver;
    }

    @Test
    public void Action3() {
        WebDriver driver = openWileyPage();
        //Check that http://www.wiley.com/WileyCDA/Section/id-404702.html url is opened
        WebElement studentsHeader = driver.findElement(By.xpath(STUDENTS_HEADER_X_PATH));
        //Check that “Students” header is displayed
        checkItemIsDisplayed(studentsHeader);
        assertEquals("Students", studentsHeader.getText());

        driver.quit();
    }

    private void checkItemIsDisplayed(WebElement studentsHeader) {
        assertTrue("Header " + studentsHeader.getText() + " is not displayed", studentsHeader.isDisplayed());
    }
}

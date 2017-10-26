import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAction05 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/Section/id-404702.html";
    private static final String RESOURCES_FOR_MENU_ELEMENTS_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li";
    private static final String STUDENT_ELEMENT_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li[@class='active autonavItem parent']/span";
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void TestAction05() {
        List<WebElement> resourcesForMenuElements = driver.findElements(By.xpath(RESOURCES_FOR_MENU_ELEMENTS_XPATH));
        WebElement studentElement = driver.findElement(By.xpath(STUDENT_ELEMENT_XPATH));
        //Check “Students” item is selected
        //“Students” item has different style
        assertFalse("'Students' item has the same style", resourcesForMenuElements.get(0).getCssValue("color").equals(studentElement.getCssValue("font-color")));
        //“Students” item is not clickable
        String pageUrl = driver.getCurrentUrl();
        studentElement.click();
        assertTrue("The click on 'Students' item changes page url", pageUrl.equals(driver.getCurrentUrl()));
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

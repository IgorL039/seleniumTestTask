import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAction04 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/Section/id-404702.html";
    private static final String RESOURCES_FOR_MENU_LINKS_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li[@class='autonavItem']/a";
    private static final String RESOURCES_FOR_MENU_CLICKED_LINK_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li/span";
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void TestAction04() {
        //Check “Resources For” menu on the left
        List<WebElement> resourcesForMenuLinks = driver.findElements(By.xpath(RESOURCES_FOR_MENU_LINKS_XPATH));
        resourcesForMenuLinks.add(driver.findElement(By.xpath(RESOURCES_FOR_MENU_CLICKED_LINK_XPATH)));
        //8 items are displayed in the menu, but 7 (There is not "Government Employees" on “Resources For” menu)
        //Items are “Authorts”, “Librarians”, “Booksellers”, “Instructors”, “Students” , “Societies”, “Corporate Partners”
        checkNumberOfLinks(resourcesForMenuLinks, 7);
        for (WebElement link : resourcesForMenuLinks) {
            checkItemIsDisplayed(link);
        }
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }

    private void checkNumberOfLinks(List<WebElement> links, int i) {
        assertEquals("The number of links is equal " + links.size() + ", not " + i, i, links.size());
    }

    private void checkItemIsDisplayed(WebElement link) {
        assertTrue("Link " + link.getText() + " is not displayed", link.isDisplayed());
    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class Action2 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/";
    private static final String RESOURCES_SUB_HEADER_LINKS_XPATH = "//div[@id='homepage-links']/ul/li/a";
    private List<String> linkNames = Arrays.asList("Students", "Authors", "Instructors", "Librarians", "Societies", "Conferences",
            "Booksellers", "Corporations", "Institutions");
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void Action2() {
        //Check items under Resources sub-header
        List<WebElement> resourcesSubHeaderLinks = driver.findElements(By.xpath(RESOURCES_SUB_HEADER_LINKS_XPATH));

        //There are 9 items under resources sub-header
        checkNumberOfLinks(resourcesSubHeaderLinks, linkNames.size());
        //Titles are 'Students', 'Authors', 'Instructors', 'Librarians', 'Societies', 'Conferences', 'Booksellers', 'Corporations', 'Institutions'
        for (WebElement link : resourcesSubHeaderLinks) {
            checkLinkIsDisplayed(link);
            checkLinkHasText(link);
        }
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }

    private void checkNumberOfLinks(List<WebElement> resourcesSubHeaderLinks, int i) {
        assertEquals("The number of links is equal " + resourcesSubHeaderLinks.size() + ", not " + i, i, resourcesSubHeaderLinks.size());
    }

    private void checkLinkHasText(WebElement link) {
        assertTrue("Link text " + link.getText() + " is not contain among " +
                        "titles 'Students', 'Authors', 'Instructors', 'Librarians', 'Societies', 'Conferences', 'Booksellers', 'Corporations', 'Institutions'",
                linkNames.contains(link.getText()));
    }

    private void checkLinkIsDisplayed(WebElement link) {
        assertTrue("Link " + link.getText() + " is not displayed", link.isDisplayed());
    }
}

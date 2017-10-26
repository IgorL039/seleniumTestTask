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
    private static final String RESOURCES_SUB_HEADER_LINKS_PATH = "//div[@id='homepage-links']/ul/li/a";
    private List<String> linkNames = Arrays.asList("Students", "Authors", "Instructors", "Librarians", "Societies", "Conferences",
            "Booksellers", "Corporations", "Institutions");
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        return driver;
    }

    @Test
    public void Action2() {
        WebDriver driver = openWileyPage();
        //Check items under Resources sub-header
        List<WebElement> resourcesSubHeaderLinks = driver.findElements(By.xpath(RESOURCES_SUB_HEADER_LINKS_PATH));

        //There are 9 items under resources sub-header
        checkNumberOfLinks(resourcesSubHeaderLinks, 9);
        //Titles are 'Students', 'Authors', 'Instructors', 'Librarians', 'Societies', 'Conferences', 'Booksellers', 'Corporations', 'Institutions'
        for (WebElement link : resourcesSubHeaderLinks) {
            checkLinkIsDisplayed(link);
            checkLinkHasText(link);
        }
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

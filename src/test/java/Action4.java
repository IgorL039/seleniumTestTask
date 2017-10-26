import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class Action4 {
    private static final String RESOURCES_FOR_MENU_LINKS_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li[@class='autonavItem']/a";
    private static final String RESOURCES_FOR_MENU_CLICKED_LINK_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li/span";
    private List<String> linkNames = Arrays.asList("Authors", "Librarians", "Booksellers", "Instructors", "Students", /*"Government Employees",*/
            "Societies", "Corporate Partners");
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        return driver;
    }

    @Test
    public void Action4() {
        WebDriver driver = openWileyPage();
        //Check “Resources For” menu on the left
        List<WebElement> resourcesForMenuLinks = driver.findElements(By.xpath(RESOURCES_FOR_MENU_LINKS_XPATH));
        resourcesForMenuLinks.add(driver.findElement(By.xpath(RESOURCES_FOR_MENU_CLICKED_LINK_XPATH)));


        //8 items are displayed in the menu, but 7 (There is not "Government Employees" on “Resources For” menu)
        //Items are “Authorts”, “Librarians”, “Booksellers”, “Instructors”, “Students” , “Societies”, “Corporate Partners”
        assertEquals("The number of links is equal " + resourcesForMenuLinks.size() + ", not 7", 7, resourcesForMenuLinks.size());

        for (WebElement link : resourcesForMenuLinks) {
            checkItemIsDisplayed(link);
        }
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }

    private void checkItemIsDisplayed(WebElement link) {
        assertTrue("Link " + link.getText() + " is not displayed", link.isDisplayed());
    }
}

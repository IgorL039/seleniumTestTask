import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestAction01 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/";
    private static final String TOP_NAVIGATION_MENU_LINKS_XPATH = "//div[@id='links-site']/ul/li/a";
    private List<String> linkNames = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void TestAction01() {
        //Open http://www.wiley.com/WileyCDA/
        List<WebElement> topNavigationMenuLinks = driver.findElements(By.xpath(TOP_NAVIGATION_MENU_LINKS_XPATH));
        //Check the following links displayed in top navigation menu "Home" "Subjects" "About" "Wiley" "Contact Us" "Help"
        for (WebElement link : topNavigationMenuLinks) {
            checkItemIsDisplayed(link);
            checkLinkHasText(link);
        }
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }

    private void checkLinkHasText(WebElement link) {
        assertTrue("Link text " + link.getText() + " is not contain among " +
                        "titles 'Home' 'Subjects' 'About' 'Wiley' 'Contact Us' 'Help'",
                linkNames.contains(link.getText()));
    }

    private void checkItemIsDisplayed(WebElement link) {
        assertTrue("Link " + link.getText() + " is not displayed", link.isDisplayed());
    }
}


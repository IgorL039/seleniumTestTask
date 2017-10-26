import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Action9 {
    private static final String INPUT_ELEMENT_XPATH = "//input[@id='query']";
    private static final String BUTTON_ELEMENT_XPATH = "//input[@class='icon icon__search search-form-submit']";
    private static final String LIST_OF_ITEMS_XPATH = "//div[@id='search-results']/div[@class='product-listing size100']";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        return driver;
    }

    @Test
    public void Action9() {
        WebDriver driver = openWileyPage();

        //Find search input in the top of the page. Enter “for dummies” to the input field and press search icon next to the input field.
        WebElement inputElement = driver.findElement(By.xpath(INPUT_ELEMENT_XPATH));
        inputElement.sendKeys("for dummies");

        WebElement buttonElement = driver.findElement(By.xpath(BUTTON_ELEMENT_XPATH));
        buttonElement.click();

        //Check that list of items appeared
        List<WebElement> list = driver.findElements(By.xpath(LIST_OF_ITEMS_XPATH));
        assertTrue("List of items didn't appear", list.size() > 1);
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

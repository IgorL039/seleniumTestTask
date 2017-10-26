import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TestAction10 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/";
    private static final String INPUT_ELEMENT_XPATH = "//input[@id='query']";
    private static final String BUTTON_ELEMENT_XPATH = "//input[@class='icon icon__search search-form-submit']";
    private static final String LIST_OF_ITEMS_XPATH = "//div[@id='search-results']/div[@class='product-listing size100']";
    private static final String HEADER_XPATH = "//h1[@class='productDetail-title']";
    private static final String ITEM_ELEMENT_LINK_XPATH = "div[@class='product-title']/a";
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void TestAction10() {
        driver.findElement(By.xpath(INPUT_ELEMENT_XPATH)).sendKeys("for dummies");
        driver.findElement(By.xpath(BUTTON_ELEMENT_XPATH)).click();
        List<WebElement> list = driver.findElements(By.xpath(LIST_OF_ITEMS_XPATH));

        //Click random item link (link with book title)
        Random rn = new Random();
        int rnd = rn.nextInt(list.size());

        WebElement randomItemLinkElement = list.get(rnd).findElement(By.xpath(ITEM_ELEMENT_LINK_XPATH));
        String linkTxt = randomItemLinkElement.getText();
        randomItemLinkElement.click();
        //Check that page with header equal to the title you clicked is displayed
        WebElement header = driver.findElement(By.xpath(HEADER_XPATH));
        assertEquals("Item header text is not equal item page title.", linkTxt, header.getText());
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }

}

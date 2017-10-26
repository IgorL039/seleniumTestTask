import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

public class Action10 {
    private static final String INPUT_ELEMENT_X_PATH = "//input[@id='query']";
    private static final String BUTTON_ELEMENT_X_PATH = "//input[@class='icon icon__search search-form-submit']";
    private static final String LIST_OF_ITEMS_X_PATH = "//div[@id='search-results']/div[@class='product-listing size100']";
    private static final String HEADER_X_PATH = "//h1[@class='productDetail-title']";
    private static final String ITEM_ELEMENT_LINK_X_PATH = "div[@class='product-title']/a";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        return driver;
    }

    @Test
    public void Action10() {
        WebDriver driver = openWileyPage();

        WebElement inputElement = driver.findElement(By.xpath(INPUT_ELEMENT_X_PATH));
        inputElement.sendKeys("for dummies");

        WebElement buttonElement = driver.findElement(By.xpath(BUTTON_ELEMENT_X_PATH));
        buttonElement.click();

        List<WebElement> list = driver.findElements(By.xpath(LIST_OF_ITEMS_X_PATH));

        //Click random item link (link with book title)
        Random rn = new Random();
        int rnd = rn.nextInt(list.size());

        WebElement itemElementLink = list.get(rnd).findElement(By.xpath(ITEM_ELEMENT_LINK_X_PATH));
        String linkTxt = itemElementLink.getText();
        itemElementLink.click();
        //Check that page with header equal to the title you clicked is displayed
        WebElement header = driver.findElement(By.xpath(HEADER_X_PATH));
        assertEquals(linkTxt, header.getText());
        driver.quit();
    }
}

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

public class Action5 {
    private static final String RESOURCES_FOR_MENU_ELEMENTS_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li";
    private static final String STUDENT_ELEMENT_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li[@class='active autonavItem parent']/span";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        return driver;
    }

    @Test
    public void Action5() {
        WebDriver driver = openWileyPage();
        List<WebElement> resourcesForMenuElements = driver.findElements(By.xpath(RESOURCES_FOR_MENU_ELEMENTS_XPATH));
        WebElement studentElement = driver.findElement(By.xpath(STUDENT_ELEMENT_XPATH));
        //Check “Students” item is selected
        //“Students” item has different style
        assertFalse("'Students' item has the same style", resourcesForMenuElements.get(0).getCssValue("color").equals(studentElement.getCssValue("font-color")));

        //“Students” item is not clickable
        String pageUrl = driver.getCurrentUrl();
        studentElement.click();
//        new WebDriverWait(driver, 5);
        assertEquals("The click on 'Students' item changes page url", true, pageUrl.equals(driver.getCurrentUrl()));
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

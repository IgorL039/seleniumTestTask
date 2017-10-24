import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class Test01 {

    @Test
    public void DoTest() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        //Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        //Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

    @Test
    public void Action1() {
        WebDriver d = new ChromeDriver();
        d.get("http://www.wiley.com/WileyCDA/");
        List<WebElement> links = d.findElements(By.xpath("//div[@id='links-site']/ul/li/a"));

        List<String> linkNames = new ArrayList<String>();
        linkNames.add("");

        boolean isDispl = true;
        for (WebElement l : links) {
            isDispl &= l.isDisplayed();
        }
        assertEquals(true, isDispl);
        ///newnew
        d.quit();
    }
}
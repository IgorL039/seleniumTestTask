import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action6 {
    private static final String HOME_ELEMENT_XPATH = "//div[@id='links-site']/ul/li/a[contains(., 'Home')]";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        return driver;
    }

    @Test
    public void Action6() {
        WebDriver driver = openWileyPage();
        //Click “Home” link at the top navigation menu
        WebElement homeElement = driver.findElement(By.xpath(HOME_ELEMENT_XPATH));
        homeElement.click();
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

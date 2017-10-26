import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action11 {
    private static final String HOME_ELEMENT_XPATH = "//div[@id='links-site']/ul/li/a[contains(., 'Home')]";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        return driver;
    }

    @Test
    public void Action11() {
        //Click “Home” link at the top navigation menu
        WebDriver driver = openWileyPage();
        WebElement homeElement = driver.findElement(By.xpath(HOME_ELEMENT_XPATH));
        homeElement.click();
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

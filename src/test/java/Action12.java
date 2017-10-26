import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class Action12 {
    private static final String ELEMENT_INSTITUTIONS_XPATH = "//div[@id='homepage-links']/ul/li[@class='resource-institutions']";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        return driver;
    }

    @Test
    public void Action12() {
        WebDriver driver = openWileyPage();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //Click “Institutions” icon under Resources sub-header
        WebElement elementInstitutions = driver.findElement(By.xpath(ELEMENT_INSTITUTIONS_XPATH));
        elementInstitutions.click();
        //Check http://wileyedsolutions.com/ is opened in new window (or tab) //https://edservices.wiley.com/
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals("https://edservices.wiley.com/", driver.getCurrentUrl());
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

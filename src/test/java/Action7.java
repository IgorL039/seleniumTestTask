import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class Action7 {
    private static final String BUTTON_ELEMENT_X_PATH = "//button[@id='id31']";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        return driver;
    }

    @Test
    public void Action7() {
        WebDriver driver = openWileyPage();
        //Find “Sign up to receive Wiley updates” line and input field next to it. Do not enter anything and click arrow button
        WebElement buttonElement = driver.findElement(By.xpath(BUTTON_ELEMENT_X_PATH));
        buttonElement.click();
        //Check that alert appeared
        Alert alert = driver.switchTo().alert();
        //Check that alert text is “Please enter email address”
        assertEquals("Please enter email address", alert.getText());
        driver.quit();
    }
}

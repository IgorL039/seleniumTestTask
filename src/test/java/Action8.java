import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class Action8 {
    private static final String INPUT_ELEMENT_XPATH = "//input[@id='EmailAddress']";
    private static final String BUTTON_ELEMENT_XPATH = "//button[@id='id31']";
    private WebDriver driver;

    private WebDriver openWileyPage() {
        driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        return driver;
    }

    @Test
    public void Action8() {
        WebDriver driver = openWileyPage();

        WebElement inputElement = driver.findElement(By.xpath(INPUT_ELEMENT_XPATH));
        //Enter invalid email (for example without @)
        inputElement.sendKeys("mail.mail.ru");

        WebElement buttonElement = driver.findElement(By.xpath(BUTTON_ELEMENT_XPATH));
        buttonElement.click();
        //Check that alert appeared
        Alert alert = driver.switchTo().alert();
        //Check that alert text is “Invalid email address.”
        assertEquals("Invalid email address.", alert.getText());
    }

    @After
    public void CloseBrowser() {
        driver.quit();
    }
}

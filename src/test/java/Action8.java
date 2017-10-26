import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class Action8 {
    private static final String TEST_PAGE_URL = "http://www.wiley.com/WileyCDA/";
    private static final String INPUT_ELEMENT_XPATH = "//input[@id='EmailAddress']";
    private static final String BUTTON_ELEMENT_XPATH = "//button[@id='id31']";
    private WebDriver driver = new ChromeDriver();

    @Before
    public void openWileyPage() {
        driver.get(TEST_PAGE_URL);
    }

    @Test
    public void Action8() {
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

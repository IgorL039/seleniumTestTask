import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.StudentSectionHomePage;

public class CommonTestMethods {
    private WebDriver driver = new ChromeDriver();

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public void openHome() {
        driver.get("http://eu.wiley.com/WileyCDA/");
    }

    public StudentSectionHomePage getStudentSectionHomePage() {
        return new StudentSectionHomePage(driver);
    }

    public void openStudentSectionHome() {
        driver.get("http://eu.wiley.com/WileyCDA/Section/id-404702.html");
    }

    public void closeBrowser() {
        driver.quit();
    }
}

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> linkNames = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");

        boolean flag = true;
        for (WebElement l : links) {
            flag &= l.isDisplayed() & linkNames.contains(l.getText());
        }
        assertEquals(true, flag);
        d.quit();
    }

    @Test
    public void Action2() {
        WebDriver d = new ChromeDriver();
        d.get("http://www.wiley.com/WileyCDA/");
        List<WebElement> links = d.findElements(By.xpath("//div[@id='homepage-links']/ul/li/a"));
        List<String> linkNames = Arrays.asList("Students", "Authors", "Instructors",
                "Librarians", "Societies", "Conferences",
                "Booksellers", "Corporations", "Institutions");

        boolean flag = links.size() == 9;
        if (flag)
            for (WebElement l : links)
                flag &= l.isDisplayed() & linkNames.contains(l.getText());

        assertEquals(true, flag);
        d.quit();
    }

    @Test
    public void Action3() {
        WebDriver d = new ChromeDriver();
        d.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        WebElement el = d.findElement(By.xpath("//div[@id='page-title']/h1"));

        boolean flag = el.isDisplayed() & el.getText().equals("Students");

        assertEquals(true, flag);
        d.quit();
    }

    @Test
    public void Action4() {
        WebDriver d = new ChromeDriver();
        d.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        List<WebElement> links = d.findElements(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li[@class='autonavItem']/a"));
        links.add(d.findElement(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li/span")));

        List<String> linkNames = Arrays.asList("Authors", "Librarians", "Booksellers",
                "Instructors", "Students", /*"Government Employees",*/
                "Societies", "Corporate Partners");

        boolean flag = links.size() == 7;
        if (flag)
            for (WebElement l : links)
                flag &= l.isDisplayed() & linkNames.contains(l.getText());

        assertEquals(true, flag);
        d.quit();
    }

    @Test
    public void Action5() {
        WebDriver d = new ChromeDriver();
        d.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        List<WebElement> els = d.findElements(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li"));
        WebElement studentEl = d.findElement(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li[@class='active autonavItem parent']"));

        boolean flag = els.get(0).getCssValue("font-color").equals(studentEl.getCssValue("font-color"));

        studentEl.findElement(By);
        //if (flag)
//не доделан!!
        assertEquals(true, flag);
        d.quit();
    }
}
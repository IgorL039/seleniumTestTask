import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/");
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='links-site']/ul/li/a"));
        List<String> linkNames = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");

        boolean flag = true;
        for (WebElement l : links) {
            flag &= l.isDisplayed() & linkNames.contains(l.getText());
        }
        assertEquals(true, flag);
        driver.quit();
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
    public void Action5() {//!!!!!!!!!!!!!!!!!!!!!is not work
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");
        List<WebElement> els = driver.findElements(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li"));
        WebElement studentEl = driver.findElement(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li[@class='active autonavItem parent']"));

        boolean isDiffStyle = els.get(0).getCssValue("color").equals(studentEl.getCssValue("font-color"));

        String pageSource = driver.getPageSource();
        studentEl.click();
        boolean isNotClickable = false;
        if (pageSource.equals(driver.getPageSource())) isNotClickable = true;

        assertEquals(true, isDiffStyle & isNotClickable);
        driver.quit();
    }

    @Test
    public void Action6() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.wiley.com/WileyCDA/Section/id-404702.html");

        WebElement homeEl = driver.findElement(By.xpath("//div[@id='links-site']/ul/li/a[contains(., 'Home')]"));
        homeEl.click();
        driver.quit();
    }

    @Test
    public void Action7() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://eu.wiley.com/WileyCDA/");
        //Find “Sign up to receive Wiley updates” line and input field next to it. Do not enter anything and click arrow button
        WebElement buttonEl = driver.findElement(By.xpath("//button[@id='id31']"));
        buttonEl.click();
        //Check that alert appeared
        Alert alert = driver.switchTo().alert();
        //Check that alert text is “Please enter email address”
        assertEquals(true, alert.getText().equals("Please enter email address"));
        driver.quit();
    }

    @Test
    public void Action8() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://eu.wiley.com/WileyCDA/");

        WebElement inputEl = driver.findElement(By.xpath("//input[@id='EmailAddress']"));
        //Enter invalid email (for example without @)
        inputEl.sendKeys("mail.mail.ru");

        WebElement buttonEl = driver.findElement(By.xpath("//button[@id='id31']"));
        buttonEl.click();
        //Check that alert appeared
        Alert alert = driver.switchTo().alert();
        //Check that alert text is “Invalid email address.”
        assertEquals(true, alert.getText().equals("Invalid email address."));
        driver.quit();
    }

    @Test
    public void Action9() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://eu.wiley.com/WileyCDA/");

        //Find search input in the top of the page. Enter “for dummies” to the input field and press search icon next to the input field.
        WebElement inputEl = driver.findElement(By.xpath("//input[@id='query']"));
        inputEl.sendKeys("for dummies");

        WebElement buttonEl = driver.findElement(By.xpath("//input[@class='icon icon__search search-form-submit']"));
        buttonEl.click();

        //Check that list of items appeared
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='search-results']/div[@class='product-listing size100']"));
        assertEquals(true, list.size() > 1);

        driver.quit();
    }

    @Test
    public void Action10() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://eu.wiley.com/WileyCDA/");

        WebElement inputEl = driver.findElement(By.xpath("//input[@id='query']"));
        inputEl.sendKeys("for dummies");

        WebElement buttonEl = driver.findElement(By.xpath("//input[@class='icon icon__search search-form-submit']"));
        buttonEl.click();

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='search-results']/div[@class='product-listing size100']"));

        //Click random item link (link with book title)
        Random rn = new Random();
        int rnd = rn.nextInt(list.size());

        WebElement link = list.get(rnd).findElement(By.xpath("div[@class='product-title']/a"));
        WebElement item = list.get(rnd);
        String linkTxt = link.getText();
        link.click();
        //Check that page with header equal to the title you clicked is displayed
        WebElement header = driver.findElement(By.xpath("//h1[@class='productDetail-title']"));
        assertEquals(true, header.getText().equals(linkTxt));

        driver.quit();
    }

    @Test
    public void Action11() {
        //Click “Home” link at the top navigation menu
        Action6();
    }

    @Test
    public void Action12() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("http://eu.wiley.com/WileyCDA/");
        //Click “Institutions” icon under Resources sub-header
        WebElement el = driver.findElement(By.xpath("//div[@id='homepage-links']/ul/li[@class='resource-institutions']"));
        el.click();
        //Check http://wileyedsolutions.com/ is opened in new window (or tab) //https://edservices.wiley.com/
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        assertEquals(true, driver.getCurrentUrl().equals("https://edservices.wiley.com/"));
        driver.quit();
    }
}
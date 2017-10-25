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
    private WebDriver _driver;

    private WebDriver openWileyHomePage() {
        _driver = new ChromeDriver();
        _driver.get("http://www.wiley.com/WileyCDA/");
        return _driver;
    }

    private WebDriver openWileyHomePage(String s) {
        _driver = new ChromeDriver();
        _driver.get("http://www.wiley.com/WileyCDA/" + s);
        return _driver;
    }

    @Test
    public void Action1() {
        //Open http://www.wiley.com/WileyCDA/
        WebDriver driver = openWileyHomePage();
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='links-site']/ul/li/a"));
        //Check the following links displayed in top navigation menu "Home" "Subjects" "About" "Wiley" "Contact Us" "Help"
        List<String> linkNames = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");

        boolean flag = true;
        for (WebElement link : links) {
            assertEquals("Link " + link.getText() + " is not displayed", true, link.isDisplayed());
            assertEquals("Link text " + link.getText() + " is not contain among " +
                            "titles \"Home\" \"Subjects\" \"About\" \"Wiley\" \"Contact Us\" \"Help\"",
                    true, linkNames.contains(link.getText()));
        }

        driver.quit();
    }

    @Test
    public void Action2() {
        WebDriver driver = openWileyHomePage();
        //Check items under Resources sub-header
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='homepage-links']/ul/li/a"));
        List<String> linkNames = Arrays.asList("Students", "Authors", "Instructors",
                "Librarians", "Societies", "Conferences",
                "Booksellers", "Corporations", "Institutions");
        //There are 9 items under resources sub-header
        assertEquals("The number of links is equal " + links.size() + ", not 9", 9, links.size());
        //Titles are “Students”, “Authors”, “Instructors”, “Librarians”, “Societies”, “Conferences”, “Booksellers”, “Corporations”, “Institutions”
        for (WebElement link : links) {
            assertEquals("Link " + link.getText() + " is not displayed", true, link.isDisplayed());
            assertEquals("Link text " + link.getText() + " is not contain among " +
                            "titles “Students”, “Authors”, “Instructors”, “Librarians”, “Societies”, “Conferences”, “Booksellers”, “Corporations”, “Institutions”",
                    true, linkNames.contains(link.getText()));
        }

        driver.quit();
    }

    @Test
    public void Action3() {
        WebDriver driver = openWileyHomePage("Section/id-404702.html");
        //Check that http://www.wiley.com/WileyCDA/Section/id-404702.html url is opened
        WebElement headerStudents = driver.findElement(By.xpath("//div[@id='page-title']/h1"));
        //Check that “Students” header is displayed
        assertEquals("Header " + headerStudents.getText() + " is not displayed", true, headerStudents.isDisplayed());
        assertEquals("Header Students tex is not \"Students\"", "Students", headerStudents.getText());

        driver.quit();
    }

    @Test
    public void Action4() {
        WebDriver driver = openWileyHomePage("Section/id-404702.html");
        //Check “Resources For” menu on the left
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li[@class='autonavItem']/a"));
        links.add(driver.findElement(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li/span")));

        List<String> linkNames = Arrays.asList("Authors", "Librarians", "Booksellers",
                "Instructors", "Students", /*"Government Employees",*/
                "Societies", "Corporate Partners");
        //8 items are displayed in the menu, but 7 (There is not "Government Employees" on “Resources For” menu)
        //Items are “Authorts”, “Librarians”, “Booksellers”, “Instructors”, “Students” , “Societies”, “Corporate Partners”
        assertEquals("The number of links is equal " + links.size() + ", not 7", 7, links.size());

        for (WebElement link : links) {
            assertEquals("Link " + link.getText() + " is not displayed", true, link.isDisplayed());
        }

        driver.quit();
    }

    @Test
    public void Action5() {
        WebDriver driver = openWileyHomePage("Section/id-404702.html");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li"));
        WebElement studentElement = driver.findElement(By.xpath("//div[@id='sidebar']/div/ul/li/ul/li[@class='active autonavItem parent']/span"));
        //Check “Students” item is selected
        //“Students” item has different style
        assertEquals("“Students” item has the same style", false, elements.get(0).getCssValue("color").equals(studentElement.getCssValue("font-color")));

        //“Students” item is not clickable
        String pageUrl = driver.getCurrentUrl();
        studentElement.click();
//        new WebDriverWait(driver, 5);
        assertEquals("The click on “Students” item changes page url", true, pageUrl.equals(driver.getCurrentUrl()));

        driver.quit();
    }

    @Test
    public void Action6() {
        WebDriver driver = openWileyHomePage("Section/id-404702.html");
        //Click “Home” link at the top navigation menu
        WebElement homeElement = driver.findElement(By.xpath("//div[@id='links-site']/ul/li/a[contains(., 'Home')]"));
        homeElement.click();

        driver.quit();
    }

    @Test
    public void Action7() {
        WebDriver driver = openWileyHomePage();
        //Find “Sign up to receive Wiley updates” line and input field next to it. Do not enter anything and click arrow button
        WebElement buttonElement = driver.findElement(By.xpath("//button[@id='id31']"));
        buttonElement.click();
        //Check that alert appeared
        Alert alert = driver.switchTo().alert();
        //Check that alert text is “Please enter email address”
        assertEquals("Alert text is not equal \"Please enter email address\"", true, alert.getText().equals("Please enter email address"));
        driver.quit();
    }

    @Test
    public void Action8() {
        WebDriver driver = openWileyHomePage();

        WebElement inputElement = driver.findElement(By.xpath("//input[@id='EmailAddress']"));
        //Enter invalid email (for example without @)
        inputElement.sendKeys("mail.mail.ru");

        WebElement buttonElement = driver.findElement(By.xpath("//button[@id='id31']"));
        buttonElement.click();
        //Check that alert appeared
        Alert alert = driver.switchTo().alert();
        //Check that alert text is “Invalid email address.”
        assertEquals("Alert text is not equal \"Invalid email address.\"", true, alert.getText().equals("Invalid email address."));
        driver.quit();
    }

    @Test
    public void Action9() {
        WebDriver driver = openWileyHomePage();

        //Find search input in the top of the page. Enter “for dummies” to the input field and press search icon next to the input field.
        WebElement inputElement = driver.findElement(By.xpath("//input[@id='query']"));
        inputElement.sendKeys("for dummies");

        WebElement buttonElement = driver.findElement(By.xpath("//input[@class='icon icon__search search-form-submit']"));
        buttonElement.click();

        //Check that list of items appeared
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='search-results']/div[@class='product-listing size100']"));
        assertEquals("List of items didn't appear", true, list.size() > 1);

        driver.quit();
    }

    @Test
    public void Action10() {
        WebDriver driver = openWileyHomePage();

        WebElement inputElement = driver.findElement(By.xpath("//input[@id='query']"));
        inputElement.sendKeys("for dummies");

        WebElement buttonElement = driver.findElement(By.xpath("//input[@class='icon icon__search search-form-submit']"));
        buttonElement.click();

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='search-results']/div[@class='product-listing size100']"));

        //Click random item link (link with book title)
        Random rn = new Random();
        int rnd = rn.nextInt(list.size());

        WebElement link = list.get(rnd).findElement(By.xpath("div[@class='product-title']/a"));
        String linkTxt = link.getText();
        link.click();
        //Check that page with header equal to the title you clicked is displayed
        WebElement header = driver.findElement(By.xpath("//h1[@class='productDetail-title']"));
        assertEquals("Link text is not equal header text", true, header.getText().equals(linkTxt));

        driver.quit();
    }

    @Test
    public void Action11() {
        //Click “Home” link at the top navigation menu
        Action6();
    }

    @Test
    public void Action12() {
        WebDriver driver = openWileyHomePage();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //Click “Institutions” icon under Resources sub-header
        WebElement elementInstitutions = driver.findElement(By.xpath("//div[@id='homepage-links']/ul/li[@class='resource-institutions']"));
        elementInstitutions.click();
        //Check http://wileyedsolutions.com/ is opened in new window (or tab) //https://edservices.wiley.com/
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        assertEquals("New page url is not equal https://edservices.wiley.com/", true, driver.getCurrentUrl().equals("https://edservices.wiley.com/"));
        driver.quit();
    }
}
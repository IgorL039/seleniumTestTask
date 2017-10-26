package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage {
    private static final String RESOURCES_SUB_HEADER_LINKS_XPATH = "//div[@id='homepage-links']/ul/li/a";
    private List<String> linkNames = Arrays.asList("Students", "Authors", "Instructors", "Librarians", "Societies", "Conferences",
            "Booksellers", "Corporations", "Institutions");
    private static final List LINK_NAMES = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");
    private static final String BUTTON_ELEMENT_XPATH = "//button[@id='id31']";
    private static final String SIGN_UP_TO_RECEIVE_INPUT_ELEMENT_XPATH = "//input[@id='EmailAddress']";
    private static final String SEARCH_INPUT_ELEMENT_XPATH = "//input[@id='query']";
    private static final String LOUPE_BUTTON_ELEMENT_XPATH = "//input[@class='icon icon__search search-form-submit']";
    private static final String LIST_OF_ITEMS_XPATH = "//div[@id='search-results']/div[@class='product-listing size100']";
    private static final String HEADER_XPATH = "//h1[@class='productDetail-title']";
    private static final String ITEM_ELEMENT_LINK_XPATH = "div[@class='product-title']/a";
    private static final String HOME_ELEMENT_XPATH = "//div[@id='links-site']/ul/li/a[contains(., 'Home')]";
    private static final String INSTITUTIONS_ELEMENT_XPATH = "//div[@id='homepage-links']/ul/li[@class='resource-institutions']";


    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage checkTopMenuLinksAreDisplayed() {
        for (WebElement link : getLinksElements()) {
            Assert.assertTrue("Link:" + link.getText() + "is not displayed.", link.isDisplayed());
        }
        return this;
    }

    public HomePage checkTopMenuLinksHaveText() {
        Assert.assertEquals(LINK_NAMES.size(), getLinksElements().size());
        for (int linkIndex = 0; linkIndex < LINK_NAMES.size(); linkIndex++) {
            Assert.assertEquals(LINK_NAMES.get(linkIndex), getLinksElements().get(linkIndex).getText());
        }
        return this;
    }

    private List<WebElement> getLinksElements() {
        return driver.findElements(By.xpath("//div[@id='links-site']/ul/li/a"));
    }

    private List<WebElement> getResourcesSubHeaderLinks() {
        return driver.findElements(By.xpath(RESOURCES_SUB_HEADER_LINKS_XPATH));
    }

    public HomePage checkNumberOfResourcesSubHeaderLinks() {
        checkNumberOfLinks(getResourcesSubHeaderLinks(), linkNames.size());
        return this;
    }

    public HomePage checkResourcesSubHeaderLinksAreDisplayed() {
        for (WebElement link : getResourcesSubHeaderLinks()) {
            checkLinkIsDisplayed(link);
        }
        return this;
    }

    public HomePage checkResourcesSubHeaderLinksHaveText() {
        for (WebElement link : getResourcesSubHeaderLinks()) {
            checkLinkHasText(link);
        }
        return this;
    }

    private void checkNumberOfLinks(List<WebElement> links, int i) {
        assertEquals("The number of links is equal " + links.size() + ", not " + i, i, links.size());
    }

    private void checkLinkHasText(WebElement link) {
        assertTrue("Link text " + link.getText() + " is not contain among " +
                        "titles 'Students', 'Authors', 'Instructors', 'Librarians', 'Societies', 'Conferences', 'Booksellers', 'Corporations', 'Institutions'",
                linkNames.contains(link.getText()));
    }

    private void checkLinkIsDisplayed(WebElement link) {
        assertTrue("Link " + link.getText() + " is not displayed", link.isDisplayed());
    }

    public HomePage clickArrowButton() {
        getArrowButton().click();
        return this;
    }

    public HomePage checkAlertAppearance() {
        getAlert();
        return this;
    }

    public HomePage checkAlertTextMessage(String s) {
        assertEquals(s, getAlert().getText());
        return this;
    }

    private WebElement getArrowButton() {
        return driver.findElement(By.xpath(BUTTON_ELEMENT_XPATH));
    }

    private Alert getAlert() {
        return driver.switchTo().alert();
    }

    public HomePage enterTextIntoSignUpToReceiveInputElement() {
        getSignUpToReceiveInputElement().sendKeys("mail.mail.ru");
        return this;
    }

    private WebElement getSignUpToReceiveInputElement() {
        return driver.findElement(By.xpath(SIGN_UP_TO_RECEIVE_INPUT_ELEMENT_XPATH));
    }

    public HomePage enterTextIntoSearchInputElement() {
        getIntoSearchInputElement().sendKeys("for dummies");
        return this;
    }

    public HomePage clickLoupeButton() {
        getLoupeButton().click();
        return this;
    }

    public HomePage checkItemListAppearance() {
        assertTrue("List of items didn't appear", getItemList().size() > 1);
        return this;
    }

    private WebElement getIntoSearchInputElement() {
        return driver.findElement(By.xpath(SEARCH_INPUT_ELEMENT_XPATH));
    }

    private WebElement getLoupeButton() {
        return driver.findElement(By.xpath(LOUPE_BUTTON_ELEMENT_XPATH));
    }

    private List<WebElement> getItemList() {
        return driver.findElements(By.xpath(LIST_OF_ITEMS_XPATH));
    }

    public HomePage checkRandomItemPageHeader() {
        WebElement randomItemLinkElement = getRandomItemLinkElement();
        String linkTxt = randomItemLinkElement.getText();
        randomItemLinkElement.click();
        assertEquals("Item header text is not equal item page title.", linkTxt, getItemPageHeader().getText());
        return this;
    }

    private WebElement getItemPageHeader() {
        return driver.findElement(By.xpath(HEADER_XPATH));
    }

    private WebElement getRandomItemLinkElement() {
        Random rn = new Random();
        int rnd = rn.nextInt(getItemList().size());
        return getItemList().get(rnd).findElement(By.xpath(ITEM_ELEMENT_LINK_XPATH));
    }

    public HomePage clickHomeElement() {
        getHomeElement().click();
        return this;
    }

    private WebElement getHomeElement() {
        return driver.findElement(By.xpath(HOME_ELEMENT_XPATH));
    }

    public HomePage clickInstitutionElement() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        getInstitutionsElement().click();
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        return this;
    }

    public HomePage SwitchToNewOpenedTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public HomePage checkPageUrl() {
        assertEquals("https://edservices.wiley.com/", driver.getCurrentUrl());
        return this;
    }

    private WebElement getInstitutionsElement() {
        return driver.findElement(By.xpath(INSTITUTIONS_ELEMENT_XPATH));
    }


}

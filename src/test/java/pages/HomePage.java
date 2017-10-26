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
    private static final By  RESOURCES_SUB_HEADER_ELEMENTS_XPATH = By.xpath("//div[@id='homepage-links']/ul/li/a");
    private static final By  RESOURCES_BAR_INSTITUTIONS_ELEMENT_XPATH = By.xpath("//div[@id='homepage-links']/ul/li[@class='resource-institutions']");
    private static final By  SIGN_UP_TO_RECEIVE_SUBMIT_BUTTON_XPATH = By.xpath("//button[@id='id31']");
    private static final By  SIGN_UP_TO_RECEIVE_INPUT_ELEMENT_XPATH = By.xpath("//input[@id='EmailAddress']");
    private static final By  SEARCH_INPUT_ELEMENT_XPATH = By.xpath("//input[@id='query']");
    private static final By  SEARCH_SUBMIT_BUTTON_XPATH = By.xpath("//input[@class='icon icon__search search-form-submit']");
    private static final By  PRODUCT_LIST_OF_ITEMS_XPATH = By.xpath("//div[@id='search-results']/div[@class='product-listing size100']");
    private static final By  PRODUCT_PAGE_HEADER_XPATH = By.xpath("//h1[@class='productDetail-title']");
    private static final By  PRODUCT_ITEM_INFORMATION_LINK_XPATH = By.xpath("div[@class='product-title']/a");
    private static final By  TOP_NAV_HOME_ELEMENT_XPATH = By.xpath("//div[@id='links-site']/ul/li/a[contains(., 'Home')]");
    private static final List TOP_NAV_LINK_NAMES = Arrays.asList("Home", "Subjects", "About Wiley", "Contact Us", "Help");
    private static final List RESOURCES_BAR_ELEMENT_NAMES = Arrays.asList("Students", "Authors", "Instructors", "Librarians", "Societies", "Conferences",
            "Booksellers", "Corporations", "Institutions");
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
        Assert.assertEquals(TOP_NAV_LINK_NAMES.size(), getLinksElements().size());
        for (int linkIndex = 0; linkIndex < TOP_NAV_LINK_NAMES.size(); linkIndex++) {
            Assert.assertEquals(TOP_NAV_LINK_NAMES.get(linkIndex), getLinksElements().get(linkIndex).getText());
        }
        return this;
    }

    public HomePage checkNumberOfResourcesSubHeaderLinks() {
        checkNumberOfLinks(getResourcesSubHeaderLinks(), RESOURCES_BAR_ELEMENT_NAMES.size());
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

    public HomePage enterTextIntoSignUpToReceiveInputElement() {
        getSignUpToReceiveInputElement().sendKeys("mail.mail.ru");
        return this;
    }

    private WebElement getSignUpToReceiveInputElement() {
        return driver.findElement(SIGN_UP_TO_RECEIVE_INPUT_ELEMENT_XPATH);
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

    public HomePage checkRandomItemPageHeader() {
        WebElement randomItemLinkElement = getRandomItemLinkElement();
        String linkTxt = randomItemLinkElement.getText();
        randomItemLinkElement.click();
        assertEquals("Item header text is not equal item page title.", linkTxt, getItemPageHeader().getText());
        return this;
    }

    public HomePage clickHomeElement() {
        getHomeElement().click();
        return this;
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

    private WebElement getIntoSearchInputElement() {
        return driver.findElement(SEARCH_INPUT_ELEMENT_XPATH);
    }

    private WebElement getLoupeButton() {
        return driver.findElement(SEARCH_SUBMIT_BUTTON_XPATH);
    }

    private WebElement getItemPageHeader() {
        return driver.findElement(PRODUCT_PAGE_HEADER_XPATH);
    }

    private WebElement getRandomItemLinkElement() {
        Random rn = new Random();
        int rnd = rn.nextInt(getItemList().size());
        return getItemList().get(rnd).findElement(PRODUCT_ITEM_INFORMATION_LINK_XPATH);
    }

    private WebElement getHomeElement() {
        return driver.findElement(TOP_NAV_HOME_ELEMENT_XPATH);
    }

    private WebElement getInstitutionsElement() {
        return driver.findElement(RESOURCES_BAR_INSTITUTIONS_ELEMENT_XPATH);
    }

    private WebElement getArrowButton() {
        return driver.findElement(SIGN_UP_TO_RECEIVE_SUBMIT_BUTTON_XPATH);
    }

    private List<WebElement> getItemList() {
        return driver.findElements(PRODUCT_LIST_OF_ITEMS_XPATH);
    }

    private List<WebElement> getLinksElements() {
        return driver.findElements(By.xpath("//div[@id='links-site']/ul/li/a"));
    }

    private List<WebElement> getResourcesSubHeaderLinks() {
        return driver.findElements(RESOURCES_SUB_HEADER_ELEMENTS_XPATH);
    }

    private void checkNumberOfLinks(List<WebElement> links, int i) {
        assertEquals("The number of links is equal " + links.size() + ", not " + i, i, links.size());
    }

    private void checkLinkHasText(WebElement link) {
        assertTrue("Link text " + link.getText() + " is not contain among " +
                        "titles 'Students', 'Authors', 'Instructors', 'Librarians', 'Societies', 'Conferences', 'Booksellers', 'Corporations', 'Institutions'",
                RESOURCES_BAR_ELEMENT_NAMES.contains(link.getText()));
    }

    private void checkLinkIsDisplayed(WebElement link) {
        assertTrue("Link " + link.getText() + " is not displayed", link.isDisplayed());
    }

    private Alert getAlert() {
        return driver.switchTo().alert();
    }
}

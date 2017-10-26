package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class StudentSectionHomePage {
    private static final String STUDENTS_PAGE_HEADER_XPATH = "//div[@id='page-title']/h1";
    private static final String RESOURCES_FOR_MENU_LINKS_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li[@class='autonavItem']/a";
    private static final String RESOURCES_FOR_MENU_CLICKED_LINK_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li/span";
    private static final String RESOURCES_FOR_MENU_ELEMENTS_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li";
    private static final String RESOURCES_FOR_MENU_STUDENT_LINK_XPATH = "//div[@id='sidebar']/div/ul/li/ul/li[@class='active autonavItem parent']/span";
    private static final String TOP_NAV_HOME_ELEMENT_XPATH = "//div[@id='links-site']/ul/li/a[contains(., 'Home')]";
    private final WebDriver driver;

    public StudentSectionHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public StudentSectionHomePage checkStudentsHeaderIsDisplayed() {
        assertTrue("Header " + getStudentsHeader().getText() + " is not displayed", getStudentsHeader().isDisplayed());
        return this;
    }

    public StudentSectionHomePage checkStudentsHeaderHasText() {
        assertEquals("Students", getStudentsHeader().getText());
        return this;
    }

    public StudentSectionHomePage checkNumberOfResourcesForMenuLinks() {
        checkNumberOfLinks(getResourcesForMenuLinks(), 7);
        return this;
    }

    public StudentSectionHomePage checkResourcesForMenuLinksAreDisplayed() {
        for (WebElement link : getResourcesForMenuLinks()) {
            checkItemIsDisplayed(link);
        }
        return this;
    }

    public StudentSectionHomePage checkStudentElementStyle() {
        assertFalse("'Students' item has the same style",
                getResourcesForMenuElements().get(0).getCssValue("color").
                        equals(getStudentElement().getCssValue("font-color")));
        return this;
    }

    public StudentSectionHomePage checkStudentElementIsNotClickable() {
        String pageUrl = driver.getCurrentUrl();
        getStudentElement().click();
        assertTrue("The click on 'Students' item changes page url", pageUrl.equals(driver.getCurrentUrl()));
        return this;
    }

    public StudentSectionHomePage clickHomeElement() {
        getHomeElement().click();
        return this;
    }

    private WebElement getHomeElement() {
        return driver.findElement(By.xpath(TOP_NAV_HOME_ELEMENT_XPATH));
    }

    private WebElement getStudentsHeader() {
        return driver.findElement(By.xpath(STUDENTS_PAGE_HEADER_XPATH));
    }

    private List<WebElement> getResourcesForMenuLinks() {
        List<WebElement> resourcesForMenuLinks = driver.findElements(By.xpath(RESOURCES_FOR_MENU_LINKS_XPATH));
        resourcesForMenuLinks.add(driver.findElement(By.xpath(RESOURCES_FOR_MENU_CLICKED_LINK_XPATH)));
        return resourcesForMenuLinks;
    }

    private void checkNumberOfLinks(List<WebElement> links, int i) {
        assertEquals("The number of links is equal " + links.size() + ", not " + i, i, links.size());
    }

    private void checkItemIsDisplayed(WebElement link) {
        assertTrue("Link " + link.getText() + " is not displayed", link.isDisplayed());
    }

    private List<WebElement> getResourcesForMenuElements() {
        return driver.findElements(By.xpath(RESOURCES_FOR_MENU_ELEMENTS_XPATH));
    }

    private WebElement getStudentElement() {
        return driver.findElement(By.xpath(RESOURCES_FOR_MENU_STUDENT_LINK_XPATH));
    }
}

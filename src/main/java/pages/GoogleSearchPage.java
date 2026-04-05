package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage {

    WebDriver driver;
    WebDriverWait wait;

    // Google search input box
    @FindBy(name = "q")
    WebElement searchBox;

    // Search results container
    @FindBy(id = "search")
    WebElement searchResults;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void navigateToGoogle() {
        driver.get("https://www.google.com/");
    }

    public void enterSearchQuery(String query) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(query);
    }

    public void pressEnter() {
        searchBox.sendKeys(Keys.ENTER);
    }

    public void waitForResults() {
        wait.until(ExpectedConditions.visibilityOf(searchResults));
    }

    public void searchOnGoogle(String query) {
        navigateToGoogle();
        enterSearchQuery(query);
        pressEnter();
        waitForResults();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

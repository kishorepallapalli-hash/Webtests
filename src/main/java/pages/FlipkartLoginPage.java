package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlipkartLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Close login popup button (if it appears)
    @FindBy(xpath = "//button[contains(text(),'✕')]")
    WebElement closePopup;

    // Login button on homepage
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginLink;

    // Phone/Email input
    @FindBy(xpath = "//input[@class='_2IX_2-']")
    WebElement emailPhoneField;

    // Password input
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    // Login submit button
    @FindBy(xpath = "//button[contains(@class,'_2KpZ6l') and text()='Login']")
    WebElement loginButton;

    public FlipkartLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void navigateToFlipkart() {
        driver.get("https://www.flipkart.com/");
    }

    public void closeLoginPopupIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closePopup));
            closePopup.click();
        } catch (Exception e) {
            // Popup not present, continue
            System.out.println("No popup appeared, continuing...");
        }
    }

    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }

    public void enterEmailOrPhone(String emailOrPhone) {
        wait.until(ExpectedConditions.visibilityOf(emailPhoneField));
        emailPhoneField.clear();
        emailPhoneField.sendKeys(emailOrPhone);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void loginToFlipkart(String emailOrPhone, String password) {
        navigateToFlipkart();
        closeLoginPopupIfPresent();
        clickLoginLink();
        enterEmailOrPhone(emailOrPhone);
        enterPassword(password);
        clickLoginButton();
    }
}

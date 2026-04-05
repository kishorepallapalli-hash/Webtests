package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyntraLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public MyntraLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToMyntra() {
        driver.get("https://www.myntra.com/");
    }

    public void clickProfileIcon() {
        // New locator
        WebElement profileIcon = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class,'user')]")));
        profileIcon.click();
    }

    public void enterEmailOrPhone(String emailOrPhone) {
        WebElement email = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='text']")));
        email.clear();
        email.sendKeys(emailOrPhone);
    }

    public void clickContinue() {
        WebElement continueBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Continue')]")));
        continueBtn.click();
    }

    public void enterPassword(String password) {
        WebElement pwd = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='password']")));
        pwd.clear();
        pwd.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Login')]")));
        loginBtn.click();
    }
}
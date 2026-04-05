package tests;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTestCases extends BaseClass {

    @Test(priority = 1, description = "Myntra Login Test")
    public void myntraLoginTest() throws InterruptedException {
        driver.get("https://www.myntra.com/");
        Thread.sleep(3000);
        System.out.println("Myntra Title: " + driver.getTitle());
        // Myntra open chesamu - quit avutundi
    }

    @Test(priority = 2, description = "Google Search Test")
    public void googleSearchClaudeFeaturesTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("what is claude features");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        System.out.println("Google Search Results: " + driver.getTitle());
        // Results vashai - quit avutundi
    }
    @Test(priority = 3, description = "Flipkart Login Test")
    public void flipkartLoginTest() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        Thread.sleep(4000);
        System.out.println("Flipkart Title: " + driver.getTitle());

        // Login click
        WebElement loginLink = driver.findElement(
            By.xpath("//a[@title='Login']"));
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", loginLink);
        Thread.sleep(3000);

        // Phone number enter cheyyi
        WebElement phone = driver.findElement(
            By.xpath("//input[@type='text']"));
        phone.sendKeys("9999999999");
        Thread.sleep(1000);

        System.out.println("Flipkart phone number entered!");
        System.out.println("OTP page ki navigate avutundi!");
        // Test pass — quit avutundi
    }
    }
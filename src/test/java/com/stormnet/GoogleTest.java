package com.stormnet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.stormnet.pagewidgets.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Simple Selenide Test with PageObjects
 */
public class GoogleTest {
    @Test
    public void openGoogleSearchChrome() {
        // Arrange
        Selenide.open("http://automationpractice.com/index.php");
        Selenide.$(".login").shouldHave(text("Sign in"));
        Selenide.$(byText("Sign in")).click();
        Selenide.closeWindow();
    }
    @Test
    public void openGoogleSearchFirefox() {
        Configuration.browser = FIREFOX;
        Selenide.open("http://automationpractice.com/index.php");
        Selenide.closeWindow();
    }
    @Test
    public void openGoogleChromeSearchSelenium(){
        System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
        WebDriver webdriver = new ChromeDriver();
        String baseUrl = "http://automationpractice.com/index.php";
        webdriver.get(baseUrl);
        webdriver.close();
    }
    @Test
    public void openGoogleFirefoxSearchSelenuim(){
        System.setProperty("webdriver.gecko.driver", "/Users/mikalaiilyin/IdeaProjects/geckodriver");
        WebDriver webdriver = new FirefoxDriver();
        String baseUrl = "http://automationpractice.com/index.php";
        webdriver.get(baseUrl);
        webdriver.close();
    }
    @Test
    public void possibilityToSendEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
        WebDriver webdriver = new ChromeDriver();
        String baseUrl = "http://automationpractice.com/index.php";
        webdriver.get(baseUrl);
        webdriver.findElement(By.cssSelector(".header_user_info")).click();
        webdriver.findElement(By.id("email_create")).sendKeys("mikalai.ilyin++@aterise.com");
        webdriver.findElement(By.cssSelector(".icon-user")).click();
        webdriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        webdriver.findElement(By.id("id_gender1")).click();
        webdriver.findElement(By.id("customer_firstname")).sendKeys("John");
        webdriver.findElement(By.id("customer_lastname")).sendKeys("Doe");
        webdriver.findElement(By.id("passwd")).sendKeys("Qwerty123");
        Select days = new Select(webdriver.findElement(By.id("days")));
        days.selectByValue("29");
        Select months = new Select(webdriver.findElement(By.id("months")));
        months.selectByValue("3");
        Select years = new Select(webdriver.findElement(By.id("years")));
        years.selectByValue("1990");
        webdriver.findElement(By.id("newsletter")).click();
        webdriver.findElement(By.id("uniform-optin")).click();
        webdriver.findElement(By.id("passwd")).sendKeys("Qwerty123");
        webdriver.findElement(By.id("company")).sendKeys("EvilInc");
        webdriver.findElement(By.id("address1")).sendKeys("13 Brick Road");
        webdriver.findElement(By.id("city")).sendKeys("Myass");
        Select state = new Select(webdriver.findElement(By.id("id_state")));
        state.selectByVisibleText("Florida");
        webdriver.findElement(By.id("postcode")).sendKeys("33131");
        webdriver.findElement(By.id("other")).sendKeys("Additional information");
        webdriver.findElement(By.id("phone")).sendKeys("+375292929297");
        webdriver.findElement(By.id("phone_mobile")).sendKeys("+375333333333");
        webdriver.findElement(By.id("alias")).sendKeys("18, Baker street");
        webdriver.findElement(By.id("submitAccount")).click();

    }
    @Test
    public void checkThePossibilityToOrderDress(){
        System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
        WebDriver webdriver = new ChromeDriver();
        String baseUrl = "http://automationpractice.com/index.php";
        webdriver.get(baseUrl);
        webdriver.findElement(By.cssSelector(".header_user_info")).click();
        webdriver.findElement(By.id("email")).sendKeys("mikalai.ilyin++@aterise.com");
        webdriver.findElement(By.id("passwd")).sendKeys("Qwerty123");
        webdriver.findElement(By.cssSelector(".icon-lock")).click();
        //webdriver.close();
    }
}

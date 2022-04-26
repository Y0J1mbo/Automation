package com.stormnet;

import com.codeborne.selenide.Selenide;
import com.stormnet.pagewidgets.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        System.setProperty("selenide.browser", "firefox");
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
}

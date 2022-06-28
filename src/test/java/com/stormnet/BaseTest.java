package com.stormnet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    private static WebDriver driver;

    @BeforeAll
    public static void driverSetUp() throws MalformedURLException {
        if (driver == null) {
            //WebDriverManager.chromedriver().setup();
            // driver = new FirefoxDriver();
            System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "101.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
         driver = new RemoteWebDriver(
                URI.create("http://selenoid:4444/wd/hub").toURL(),
                capabilities
        );
        }
    }


    @AfterAll
    public static void driverTearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

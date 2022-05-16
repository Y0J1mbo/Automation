package com.stormnet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

        public static WebDriver driver;

        @BeforeAll
        public static void driverSetUp() {
            if (driver == null) {
                //WebDriverManager.chromedriver().setup();
              // driver = new FirefoxDriver();
                System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }

        /*@AfterAll
        public static void driverTearDown()
        {
            driver.quit();
        }*/

}

package com.stormnet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.stormnet.pagewidgets.*;


import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import org.junit.jupiter.api.Assertions;
import services.ui.Feature;
import services.ui.ScreenshotService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static services.ui.ScreenshotService.uiExecutor;

/**
 * Simple Selenide Test with PageObjects
 */
public class GoogleTest extends BaseTest {
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
    public void openGoogleChromeSearchSelenium() {
        System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
        WebDriver webdriver = new ChromeDriver();
        String baseUrl = "http://automationpractice.com/index.php";
        webdriver.get(baseUrl);
        uiExecutor(Feature.EXAMPLE);

        webdriver.close();
    }

    @Test
    public void openGoogleFirefoxSearchSelenuim() {
        System.setProperty("webdriver.gecko.driver", "/Users/mikalaiilyin/IdeaProjects/geckodriver");
        WebDriver webdriver = new FirefoxDriver();
        String baseUrl = "http://automationpractice.com/index.php";
        webdriver.get(baseUrl);
        webdriver.close();
    }

    @Test
    public void possibilityToSendEmail() throws InterruptedException {
        //step 1 open page and sign in
        System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
        WebDriver webdriver = new ChromeDriver();
        String baseUrl = "http://automationpractice.com/index.php";
        webdriver.get(baseUrl);
        webdriver.findElement(By.cssSelector(".header_user_info")).click();
        //step 2 email and create account
        webdriver.findElement(By.id("email_create")).sendKeys("mikalai.ilyin+test11@aterise.com");
        webdriver.findElement(By.cssSelector(".icon-user")).click();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Step 3 fill the fields
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
        //step 4 execute steps 3-11
        // step 3 click on dresses
        Actions action = new Actions(webdriver);
        WebElement dresstab = webdriver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
        action.moveToElement(dresstab).build().perform();
        webdriver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")).click();
        // step 4 hover over and click add
        WebElement dress = webdriver.findElement(By.cssSelector(".product-container"));
        action.moveToElement(dress).build().perform();
        WebElement add = webdriver.findElement(By.cssSelector(".ajax_add_to_cart_button.btn.btn-default"));
        add.click();
        // step 5
        webdriver.switchTo().activeElement();
        webdriver.findElement(By.cssSelector(".col-md-6>div.button-container>a")).click();
        // step 6 proceed address
        webdriver.findElement(By.cssSelector(".btn-default.standard-checkout.button-medium")).click();
        // step 7 shipping
        webdriver.findElement(By.cssSelector(" p > button")).click();
        // step 8 tickbox
        webdriver.findElement(By.id("cgv")).click();
        // step 9 proceed carrier
        webdriver.findElement(By.cssSelector("p > button")).click();
        // step 10 payment
        webdriver.findElement(By.cssSelector(".bankwire")).click();
        // step 11 confirm
        webdriver.findElement(By.cssSelector("#cart_navigation > button")).click();
        // Step 5 contact us
        webdriver.findElement(By.id("contact-link")).click();
        // Step 6 choose Customer service
        Select choose = new Select(webdriver.findElement(By.id("id_contact")));
        choose.selectByValue("2");
        // Step 7  order reference
        Select order = new Select(webdriver.findElement(By.xpath("//*[@name = 'id_order']")));
        order.selectByValue("435158");
        // Step 8 choose product
        Select product = new Select(webdriver.findElement(By.id("id_product")));
        product.selectByValue("3");
        // Step 9
        webdriver.findElement(By.id("message")).sendKeys("Wait, wait, Houston, we have a problem.");
        // Step 10 send click
        webdriver.findElement(By.id("submitMessage")).click();



    }

    @Test
    public void checkThePossibilityToOrderDress() {
        // System.setProperty("webdriver.chrome.driver", "/Users/mikalaiilyin/IdeaProjects/chromedriver");
        // WebDriver webdriver = new ChromeDriver();
        //step 1 open google page
        MainPage mainPage = new MainPage(getDriver());
        SignInPage signInPage = mainPage.openPage("http://automationpractice.com/index.php");
        signInPage.logIn();
        signInPage.loginAs("kickforce666@gmail.com", "123qweQWE");
        // step 3 click on dresses
        /*Actions action = new Actions(driver);
        WebElement dresstab = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
        action.moveToElement(dresstab).build().perform();*/
        mainPage.hoverDress();
        //driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")).click();
        CasualDressPage casualDressPage = mainPage.selectCasual();
        //mainPage.selectCasual();
        // step 4 hover over and click add
        /*WebElement dress = driver.findElement(By.cssSelector(".product-container"));
        action.moveToElement(dress).build().perform();*/
        casualDressPage.hoverOverDress();
        /*WebElement add = driver.findElement(By.cssSelector(".ajax_add_to_cart_button.btn.btn-default"));
        add.click();*/
        casualDressPage.pressAddBtn();
        // step 5
        //driver.switchTo().activeElement();
        casualDressPage.switchToActivate();
        //driver.findElement(By.cssSelector(".col-md-6 > div.button-container > a")).click();
        //casualDressPage.clickPopupBtn();
        // step 6 proceed address
        //driver.findElement(By.cssSelector(".btn-default.standard-checkout.button-medium")).click();
        ShoppingCartSummary shoppingCartSummary = casualDressPage.clickPopupBtn();
        shoppingCartSummary.setProccAdrs();
        // step 7 shipping
        //driver.findElement(By.cssSelector(" p > button")).click();
        shoppingCartSummary.setCheckout();
        // step 8 tickbox
        //driver.findElement(By.id("cgv")).click();
        shoppingCartSummary.setTermCondit();
        // step 9 proceed carrier
        //driver.findElement(By.cssSelector("p > button")).click();
        shoppingCartSummary.setCheckout();
        // step 10 payment
        //driver.findElement(By.cssSelector(".bankwire")).click();
        shoppingCartSummary.setBankwire();
        // step 11 confirm
        //driver.findElement(By.cssSelector("#cart_navigation > button")).click();
        shoppingCartSummary.setConfirmorder();

    }

    @Test
    public void possibilityToWriteReview() {
        //presteps
        //step 1 open google page
        MainPage mainPage = new MainPage(getDriver());
        SignInPage signInPage = mainPage.openPage("http://automationpractice.com/index.php");
        signInPage.logIn();
        signInPage.loginAs("kickforce666@gmail.com", "123qweQWE");
        //steps
        // step 1 t-shirt click
        //driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a")).click();
        Tshirt tshirt = mainPage.setTshirt();
        // step 2 hover over more
        /*Actions action = new Actions(driver);
        WebElement shirt = driver.findElement(By.cssSelector(".product_img_link"));
        action.moveToElement(shirt).build().perform();*/
        tshirt.setHoverOver();
        /*WebElement more = driver.findElement(By.cssSelector(".button.lnk_view.btn.btn-default"));
        more.click();*/
        tshirt.clickMorebtn();
        // step 3 write review click
        /*driver.findElement(By.cssSelector("#product_comments_block_extra > ul > li > a")).click();
        driver.switchTo().activeElement();*/
        tshirt.clickReviewBtn();
        tshirt.switchToActivate();
        // step 4 parameters
       /* driver.findElement(By.cssSelector(".star_content > div:nth-child(7) > a")).click();
        driver.findElement(By.id("comment_title")).sendKeys("High quality product");
        driver.findElement(By.id("content")).sendKeys("The Best of the best");*/
        tshirt.setStarQuality();
        tshirt.sendCommentTitle();
        tshirt.sendCommentContent();
        // step 5 click send
        //driver.findElement(By.id("submitNewMessage")).click();
        tshirt.clickSendBtn();
        // step 6
        //driver.switchTo().activeElement();
        tshirt.switchToActivate();
        //driver.findElement(By.cssSelector(".fancybox-opened > div > div > div > p.submit > button")).click();
        tshirt.clickOkBtn();
    }
   /* @Test
    public void dressToWishlist(){
        //presteps
        //step 1 open google page
        MainPage mainPage = new MainPage(getDriver());
        SignInPage signInPage = mainPage.openPage("http://automationpractice.com/index.php");
        signInPage.logIn();
        signInPage.loginAs("kickforce666@gmail.com", "123qweQWE");
        //STEPS
        // step 1 blouses button
        Actions action = new Actions(driver);
        WebElement dresstab = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
        action.moveToElement(dresstab).build().perform();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")).click();
        // step 2 blouse more button
        WebElement blouse = driver.findElement(By.cssSelector(".product_img_link"));
        action.moveToElement(blouse).build().perform();
        WebElement more = driver.findElement(By.cssSelector(".button.lnk_view.btn.btn-default"));
        more.click();
        // step 3 add to wishlist
        driver.findElement(By.id("wishlist_button")).click();
        // step 4 x button
        driver.switchTo().activeElement();
        driver.findElement(By.cssSelector(".fancybox-overlay-fixed > div > div > a")).click();
        // step 5 click name
        driver.findElement(By.cssSelector(".nav > div > div > nav > div:nth-child(1) > a")).click();
        // step 6 wishlist click
        driver.findElement(By.cssSelector("#center_column > div > div:nth-child(2) > ul > li > a > i")).click();
        // step 7 first wish
        //driver.findElement(By.cssSelector("#wishlist_48028 > td:nth-child(1) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"wishlist_48056\"]/td[1]/a")).click();
        // step 8 delete wish
        driver.findElement(By.xpath("//*[@id=\"wishlist_48056\"]/td[6]/a/i")).click();
        driver.switchTo().alert().accept();
    }
    @Test
    public void checkSummerDressForDiffColours(){
        // step 1 open page
        String baseUrl = "http://automationpractice.com/index.php";
        driver.get(baseUrl);
        // step 2 click on dresses->summer dresses
        Actions action = new Actions(driver);
        WebElement dresstab = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
        action.moveToElement(dresstab).build().perform();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")).click();
        // step 3 hover over dress four colours
        WebElement sumdress = driver.findElement(By.cssSelector(".product_img_link"));
        action.moveToElement(sumdress).build().perform();
        WebElement more = driver.findElement(By.cssSelector(".button.lnk_view.btn.btn-default"));
        more.click();
        // step 4 click black\
        driver.findElement(By.id("color_11")).click();
        var imgLnkBl = driver.findElement(By.id("bigpic")).getAttribute("src");
        //var exres = driver.findElement()
        Assertions.assertEquals(imgLnkBl, "http://automationpractice.com/img/p/1/5/15-large_default.jpg");
        // step 5 click orange
        driver.findElement(By.id("color_13")).click();
        var imgLnkOr = driver.findElement(By.id("bigpic")).getAttribute("src");
        Assertions.assertEquals(imgLnkOr,"http://automationpractice.com/img/p/1/4/14-large_default.jpg");
        // step 6 click blue
        driver.findElement(By.id("color_14")).click();
        var imgLnkBlue = driver.findElement(By.id("bigpic")).getAttribute("src");
        Assertions.assertEquals(imgLnkBlue,"http://automationpractice.com/img/p/1/3/13-large_default.jpg");
        // step 7 click yellow
        driver.findElement(By.id("color_16")).click();
        var imgLnkYe = driver.findElement(By.id("bigpic")).getAttribute("src");
        Assertions.assertEquals(imgLnkYe,"http://automationpractice.com/img/p/1/2/12-large_default.jpg");
    }*/
}
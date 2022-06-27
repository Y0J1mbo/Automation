package com.stormnet;

import org.junit.jupiter.api.*;
import pages.*;

/**
 * Simple Selenide Test with PageObjects
 */
public class GoogleTest extends BaseTest {
    /*@Test
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
    }*/

    @Test
    public void possibilityToSendEmail() {
        //step 1 open page and sign in
        MainPage mainPage = new MainPage(getDriver());
        SignInPage signInPage = mainPage.openPage("http://automationpractice.com/index.php");
        signInPage.logIn();
        signInPage.newUserCreds("mikalai.ilyin+21@aterise.com");
        CreateAccount createAccount = signInPage.createNewUser();
        createAccount.enterInfo();
        createAccount.submitButton();
        //step 4 execute steps 3-11
        // step 3 click on dresses
        mainPage.hoverDress();
        CasualDressPage casualDressPage = mainPage.selectCasual();
        // step 4 hover over and click add
        casualDressPage.hoverOverDress();
        casualDressPage.pressAddBtn();
        // step 5
        casualDressPage.switchToActivate();
        // step 6 proceed address
        ShoppingCartSummary shoppingCartSummary = casualDressPage.clickPopupBtn();
        shoppingCartSummary.setProccAdrs();
        // step 7 shipping
        shoppingCartSummary.setCheckout();
        // step 8 tickbox
        shoppingCartSummary.setTermCondit();
        // step 9 proceed carrier
        shoppingCartSummary.setCheckout();
        // step 10 payment
        shoppingCartSummary.setBankwire();
        // step 11 confirm
        shoppingCartSummary.setConfirmorder();
        String orderNumber = shoppingCartSummary.getOrderNumber();
        // Step 5 contact us
        mainPage.ContactUs();
        // Step 6 choose Customer service
        ContactUsForm.subjectHeadingChoose();
        // Step 7  order reference
        ContactUsForm.selectReference(orderNumber);
        // Step 8 choose product
        ContactUsForm.textInput();
        ContactUsForm.submitForm();
    }

    @Test
    public void checkThePossibilityToOrderDress() {
        //step 1 open google page
        MainPage mainPage = new MainPage(getDriver());
        SignInPage signInPage = mainPage.openPage("http://automationpractice.com/index.php");
        signInPage.logIn();
        signInPage.loginAs("kickforce666@gmail.com", "123qweQWE");
        // step 3 click on dresses
        mainPage.hoverDress();
        CasualDressPage casualDressPage = mainPage.selectCasual();
        // step 4 hover over and click add
        casualDressPage.hoverOverDress();
        casualDressPage.pressAddBtn();
        // step 5
        casualDressPage.switchToActivate();
        // step 6 proceed address
        ShoppingCartSummary shoppingCartSummary = casualDressPage.clickPopupBtn();
        shoppingCartSummary.setProccAdrs();
        // step 7 shipping
        shoppingCartSummary.setCheckout();
        // step 8 tickbox
        shoppingCartSummary.setTermCondit();
        // step 9 proceed carrier
        shoppingCartSummary.setCheckout();
        // step 10 payment
        shoppingCartSummary.setBankwire();
        // step 11 confirm
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
        Tshirt tshirt = mainPage.setTshirt();
        // step 2 hover over more
        tshirt.setHoverOver();
        tshirt.clickMorebtn();
        // step 3 write review click
        tshirt.clickReviewBtn();
        tshirt.switchToActivate();
        // step 4 parameters
        tshirt.setStarQuality();
        tshirt.sendCommentTitle();
        tshirt.sendCommentContent();
        // step 5 click send
        tshirt.clickSendBtn();
        // step 6
        tshirt.switchToActivate();
        tshirt.clickOkBtn();
    }

    @Test
    public void dressToWishlist() {
        //presteps
        MainPage mainPage = new MainPage(getDriver());
        SignInPage signInPage = mainPage.openPage("http://automationpractice.com/index.php");
        signInPage.logIn();
        signInPage.loginAs("kickforce666@gmail.com", "123qweQWE");
        //STEPS
        BlousesPage blousesPage = mainPage.hoverBlouse();
        blousesPage.hoverOverBlouse();
        blousesPage.pressMore();
        blousesPage.setWishButton();
        blousesPage.switchToActivate();
        blousesPage.setCloseNot();
        blousesPage.setClickName();
        blousesPage.myWishList();
        blousesPage.setFirstWish();
        blousesPage.setIconRemove();
        blousesPage.switchToAlert();
    }

    @Test
    public void checkSummerDressForDiffColours() {
        // step 1 open page
        MainPage mainPage = new MainPage(getDriver());
        mainPage.openPage("http://automationpractice.com/index.php");
        // step 2 click on dresses->summer dresses
        mainPage.hoverDress();
        SummerDresses summerDresses = mainPage.selectSummer();
        summerDresses.hoverOverDress();
        summerDresses.pressMore();
        summerDresses.chooseBlack();
        summerDresses.chooseOrange();
        summerDresses.chooseBlue();
        summerDresses.chooseYellow();
    }
}
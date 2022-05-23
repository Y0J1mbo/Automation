package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.MainPage.driver;

public class CasualDressPage {
    public CasualDressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product-container")
    static WebElement hoverdress;
    @FindBy(css = ".ajax_add_to_cart_button.btn.btn-default")
    static WebElement addbtn;
    @FindBy(css = ".col-md-6 > div.button-container > a")
    static WebElement popupBtn;


    public static void hoverOverDress() {
        Actions action = new Actions(driver);
        action.moveToElement(hoverdress).build().perform();
    }

    public static void pressAddBtn() {
        addbtn.click();
    }

    public static void switchToActivate() {
        driver.switchTo().activeElement();
    }

    public static ShoppingCartSummary clickPopupBtn() {
        popupBtn.click();
        return new ShoppingCartSummary(driver);
    }

}

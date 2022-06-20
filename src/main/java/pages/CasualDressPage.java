package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import static pages.MainPage.driver;

public class CasualDressPage extends BasePage {
    public CasualDressPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product-container")
    static WebElement hoverdress;
    @FindBy(css = ".ajax_add_to_cart_button.btn.btn-default")
    static WebElement addbtn;
    @FindBy(css = ".col-md-6 > div.button-container > a")
    static WebElement popupBtn;


    public void hoverOverDress() {
        Actions action = new Actions(driver);
        action.moveToElement(hoverdress).build().perform();
    }

    public void pressAddBtn() {
        addbtn.click();
    }

    public void switchToActivate() {
        driver.switchTo().activeElement();
    }

    public ShoppingCartSummary clickPopupBtn() {
        popupBtn.click();
        return new ShoppingCartSummary(driver);
    }

}

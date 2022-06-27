package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummary extends BasePage {
    public ShoppingCartSummary(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn-default.standard-checkout.button-medium")
    static WebElement proccAdrs;
    @FindBy(css = " p > button")
    static WebElement checkout;
    @FindBy(id = "cgv")
    static WebElement termCondit;
    @FindBy(css = ".bankwire")
    static WebElement bankwire;
    @FindBy(css = "#cart_navigation > button")
    static WebElement confirmorder;
    @FindBy(css = ".box")
    WebElement refNumber;

    public void setProccAdrs() {
        proccAdrs.click();
    }

    public void setCheckout() {
        checkout.click();
    }

    public void setTermCondit() {
        termCondit.click();
    }

    public void setBankwire() {
        bankwire.click();
    }

    public void setConfirmorder() {
        confirmorder.click();
    }

    public String getOrderNumber() {
        String orderNumber = refNumber.getText().substring(216, 225);
        return orderNumber;
    }
}

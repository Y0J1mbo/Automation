package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummary {
    public ShoppingCartSummary(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = ".btn-default.standard-checkout.button-medium")
    static WebElement proccAdrs;
    @FindBy(css = " p > button")
            static WebElement checkout;
    @FindBy (id = "cgv")
            static WebElement termCondit;
    @FindBy(css = ".bankwire")
            static WebElement bankwire;
    @FindBy(css = "#cart_navigation > button")
            static WebElement confirmorder;

    public static void setProccAdrs(){
        proccAdrs.click();
    }
    public static void setCheckout(){
        checkout.click();
    }
    public static void setTermCondit(){
        termCondit.click();
    }
    public static void setBankwire(){
        bankwire.click();
    }
    public static void setConfirmorder(){
        confirmorder.click();
    }
}

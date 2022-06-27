package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BlousesPage extends BasePage {
    public BlousesPage(WebDriver driver){
        super(driver);
    }

    @FindBy (css = ".product_img_link")
    WebElement hoverBlouse;
    @FindBy (css = ".button.lnk_view.btn.btn-default")
    WebElement more;
    @FindBy (id = "wishlist_button")
    WebElement wishButton;
    @FindBy (css = ".fancybox-overlay-fixed > div > div > a")
    WebElement closeNot;
    @FindBy (css = ".nav > div > div > nav > div:nth-child(1) > a")
    WebElement clickName;
    @FindBy (css = "#center_column > div > div:nth-child(2) > ul > li > a > i")
    WebElement myWishlist;
    @FindBy (css = "td:nth-child(1) > a")
    WebElement firstWish;
    @FindBy (css = ".icon-remove")
    WebElement iconRemove;

    public void hoverOverBlouse() {
    Actions action = new Actions(driver);
        action.moveToElement(hoverBlouse).build().perform();
}
    public void pressMore() {
        more.click();
    }
    public void setWishButton(){
        wishButton.click();
    }
    public void setCloseNot() {
        closeNot.click();
    }
    public void setClickName(){
        clickName.click();
    }
    public void myWishList(){
        myWishlist.click();
    }
    public void setFirstWish(){
        firstWish.click();
    }
    public void setIconRemove(){
        iconRemove.click();
    }
    public void switchToActivate() {
        driver.switchTo().activeElement();
    }
    public void switchToAlert () {driver.switchTo().alert().accept();}
}


            /*    // step 4 x button
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
                driver.switchTo().alert().accept();*/
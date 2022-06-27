package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SummerDresses extends BasePage {
    public SummerDresses(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product_img_link")
    WebElement sumDress;
    @FindBy(css = ".button.lnk_view.btn.btn-default")
    WebElement moreButton;
    @FindBy(id = "color_11")
    WebElement blackColor;
    @FindBy(id = "color_13")
    WebElement orangeColor;
    @FindBy(id = "color_14")
    WebElement blueColor;
    @FindBy(id = "color_16")
    WebElement yellowColor;

    public void chooseBlack() {
        blackColor.click();
        driver.getCurrentUrl().contains("black");
    }

    public void chooseOrange() {
        orangeColor.click();
        driver.getCurrentUrl().contains("orange");
    }

    public void chooseBlue() {
        blueColor.click();
        driver.getCurrentUrl().contains("blue");
    }

    public void chooseYellow() {
        yellowColor.click();
        driver.getCurrentUrl().contains("yellow");
    }

    public void hoverOverDress() {
        Actions action = new Actions(driver);
        action.moveToElement(sumDress).build().perform();
    }

    public void pressMore() {
        moreButton.click();
    }
}

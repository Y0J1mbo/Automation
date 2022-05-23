package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.MainPage.driver;

public class Tshirt {
    public Tshirt(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product_img_link")
    static WebElement hovertshirt;
    @FindBy(css = ".button.lnk_view.btn.btn-default")
    static WebElement morebtn;
    @FindBy(css = "#product_comments_block_extra > ul > li > a")
    static WebElement writebtn;
    @FindBy(css = ".star_content > div:nth-child(7) > a")
    static WebElement starquality;
    @FindBy(id = "comment_title")
    static WebElement commenttitle;
    @FindBy(id = "content")
    static WebElement commentcontent;
    @FindBy(id = "submitNewMessage")
    static WebElement sendbtn;
    @FindBy(css = ".fancybox-opened > div > div > div > p.submit > button")
    static WebElement okbtn;


    public static void setHoverOver() {
        Actions action = new Actions(driver);
        action.moveToElement(hovertshirt).build().perform();
    }

    public static void clickMorebtn() {
        morebtn.click();
    }

    public static void clickReviewBtn() {
        writebtn.click();
    }

    public static void switchToActivate() {
        driver.switchTo().activeElement();
    }

    public static void setStarQuality() {
        starquality.click();
    }

    public static void sendCommentTitle() {
        commenttitle.sendKeys("High quality product");
    }

    public static void sendCommentContent() {
        commentcontent.sendKeys("The Best of the best");
    }

    public static void clickSendBtn() {
        sendbtn.click();
    }

    public static void clickOkBtn() {
        okbtn.click();
    }
}

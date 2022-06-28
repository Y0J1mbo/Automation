package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Tshirt extends BasePage {
    public Tshirt(WebDriver driver) {
        super(driver);
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
    @FindBy(css = ".fancybox-opened > div > div > div")
    static WebElement resultCheck;

    public void setHoverOver() {
        Actions action = new Actions(driver);
        action.moveToElement(hovertshirt).build().perform();
    }
    public void setResultCheck(){
        resultCheck.getText().contains("Your comment has been added and will be available once approved by a moderator");
    }

    public void clickMorebtn() {
        morebtn.click();
    }

    public void clickReviewBtn() {
        writebtn.click();
    }

    public void switchToActivate() {
        driver.switchTo().activeElement();
    }

    public void setStarQuality() {
        starquality.click();
    }

    public void sendCommentTitle() {
        commenttitle.sendKeys("High quality product");
    }

    public void sendCommentContent() {
        commentcontent.sendKeys("The Best of the best");
    }

    public void clickSendBtn() {
        sendbtn.click();
    }

    public void clickOkBtn() {
        okbtn.click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactUsForm extends BasePage {

    @FindBy(id = "id_contact")
    static
    WebElement subHeading;
    @FindBy(css = "div:nth-child(6) > div > select")
    static List<WebElement> orderRef;
    @FindBy(css = "#message")
    static WebElement messageBox;
    @FindBy(css = "#submitMessage")
    static WebElement submitMesssage;
    @FindBy(css = "#center_column > p")
    static WebElement message;

    public ContactUsForm(WebDriver driver) {
        super(driver);
    }

    public static void checkAnswer() {
        message.getText()
                .contains("Your comment has been added and will be available once approved by a moderator ");
    }
    public static void subjectHeadingChoose() {
        Select subject = new Select(subHeading);
        subject.selectByValue("2");
    }

    public static void selectReference(String referenceNumber) {
        List<WebElement> refNumber = orderRef;
        for (WebElement option : refNumber) {
            if (option.getText().contains(referenceNumber)) {
                option.click();
            }
        }
    }

    public static void textInput() {
        messageBox.sendKeys("Wait, wait, Houston, we have a problem.");
    }

    public static void submitForm() {
        submitMesssage.click();
    }

}

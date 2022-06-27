package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInPage extends BasePage {

    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(css = ".icon-lock")
    WebElement submit;
    @FindBy(css = ".header_user_info")
    WebElement login;
    @FindBy(css = "#email_create")
    WebElement enterEmail;
    @FindBy(css = "#SubmitCreate")
    WebElement createUser;

    public void logIn() {
        login.click();
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public MainPage loginAs(String emailValue, String passwordValue) {
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        submit.click();
        return new MainPage(driver);
    }

    public void newUserCreds(String newEmailValue) {
        enterEmail.sendKeys(newEmailValue);
    }

    public CreateAccount createNewUser() {
        createUser.click();
        return new CreateAccount(driver);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(css = ".icon-lock")
    WebElement submit;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage loginAs(String emailValue,String passwordValue) {
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        submit.click();
        return new MainPage(driver);
    }
}

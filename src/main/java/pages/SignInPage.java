package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage extends BasePage {
   // WebDriver driver;

    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(css = ".icon-lock")
    WebElement submit;
    @FindBy(css = ".header_user_info")
    WebElement login;
//driver.findElement(By.cssSelector(".header_user_info")).click();
    public void logIn (){
        login.click();
    }
    public SignInPage(WebDriver driver) {
        /*this.driver = driver;
        PageFactory.initElements(driver, this);*/
        super(driver);
    }

    public MainPage loginAs(String emailValue,String passwordValue) {
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        submit.click();
        return new MainPage(driver);
    }
}

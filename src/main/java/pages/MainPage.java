package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    //static WebDriver driver;
    @FindBy (css = "#block_top_menu > ul > li:nth-child(2) > a" )
            static WebElement dresstab;
    @FindBy (xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")
            static WebElement casualDress;
    @FindBy (css = "#block_top_menu > ul > li:nth-child(3) > a")
            static WebElement tshirt;

    public MainPage(WebDriver driver) {
       /* this.driver = driver;
        PageFactory.initElements(driver, this);*/
        super (driver);
    }
    public void hoverDress(){
        Actions action = new Actions(driver);
        action.moveToElement(dresstab).build().perform();
        //return new;
    }
    public SignInPage openPage(String urladdress) {
        driver.get(urladdress);
        return new SignInPage(driver);
    }
    public CasualDressPage selectCasual(){
        casualDress.click();
        return new CasualDressPage(driver);
    }
    public Tshirt setTshirt(){
        tshirt.click();
        return new Tshirt(driver);
    }
}

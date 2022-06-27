package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    static WebElement dresstab;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")
    static WebElement casualDress;
    @FindBy(xpath = "//*[@id=\'block_top_menu\']/ul/li[2]/ul/li[3]/a")
    static WebElement summerDress;
    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    static WebElement tshirt;
    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    WebElement hoverWomen;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
    WebElement blouse;
    @FindBy(id = "contact-link")
    static
    WebElement contactUs;

    public static ContactUsForm ContactUs() {
        contactUs.click();
        return new ContactUsForm(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void hoverDress() {
        Actions action = new Actions(driver);
        action.moveToElement(dresstab).build().perform();
    }

    public SignInPage openPage(String urladdress) {
        driver.get(urladdress);
        return new SignInPage(driver);
    }

    public CasualDressPage selectCasual() {
        casualDress.click();
        return new CasualDressPage(driver);
    }

    public SummerDresses selectSummer() {
        summerDress.click();
        return new SummerDresses(driver);
    }

    public Tshirt setTshirt() {
        tshirt.click();
        return new Tshirt(driver);
    }

    public BlousesPage hoverBlouse() {
        Actions action = new Actions(driver);
        action.moveToElement(hoverWomen).build().perform();
        blouse.click();
        return new BlousesPage(driver);
    }
}

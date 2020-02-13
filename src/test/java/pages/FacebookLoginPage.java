package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FacebookLoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='pass']")
    private WebElement inputPass;

    @FindBy(how = How.XPATH, using = "//label[@id='loginbutton']")
    private WebElement btnSignIn;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterEmail(String emailAddress){
        enterText(this.inputEmail, emailAddress);
    }

    public void enterPassword(String emailPassword){
        enterText(this.inputPass, emailPassword);
    }

    public void clickSignInButton() {
        click(this.btnSignIn);
        /*return PageFactory.initElements(driver, FacebookHomePage.class);*/
    }
}
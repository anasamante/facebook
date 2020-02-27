package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class FacebookLoginPage extends BasePage {


    private WebDriver driver;
    public boolean isHomeDisplayed;

    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='pass']")
    private WebElement inputPass;

    @FindBy(how = How.XPATH, using = "//label[@id='loginbutton']")
    private WebElement btnSignIn;

    @FindBy(how = How.XPATH, using = "//html[@id='facebook']//div[@id='feedx_sprouts_container']/div//span[@class='_5qtp']")
    private WebElement postBox;

    @FindBy(how = How.XPATH, using = "//*[@id=\'js_1v\']/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div/div")
    private WebElement postInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\'js_2p\']/div[2]/div[3]/div[2]/button")
    private WebElement postBtn;


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

    public FacebookLoginPage clickSignInButton() {
        click(this.btnSignIn);
        return PageFactory.initElements(driver, FacebookLoginPage.class);
    }

    public boolean isHomeDisplayed() {
        Assert.assertTrue(isElementPresent(By.xpath ("//div/a[@title='Profile']")));
        System.out.println("Home is displayed");
        return isHomeDisplayed;
    }

    public void clickCreatePost(){
        click(this.postBox);
    }

    public void createPost(String newPost){
        enterText(this.postInput, newPost);
        }

    public void clickPublishBtn() {
        click(this.postBtn);
    }
}
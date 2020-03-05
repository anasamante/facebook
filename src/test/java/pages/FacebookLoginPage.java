package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class FacebookLoginPage extends BasePage {


    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='pass']")
    private WebElement inputPass;

    @FindBy(how = How.XPATH, using = "//label[@id='loginbutton']")
    private WebElement btnSignIn;

    @FindBy(how = How.XPATH, using = "//span[text()='Crear publicación']")
    private WebElement postBox;

    @FindBy(how = How.XPATH, using = "//div[@aria-autocomplete='list']")
    private WebElement postInput;

    @FindBy(how = How.XPATH, using = "//button//span[text()='Publicar']")
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

    //clicks the postbox making it editable.
    public void clickCreatePost(){
        click(this.postBox);
    }

    //clicks on the input to type the message
    public void createPost(String newPost) {
        int attempt = 0;
        boolean clicked = false;
        do {
            try {
        enterText(this.postInput, newPost);
                clicked = true;
            } catch (NoSuchElementException e) {
                attempt++;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (attempt < 3 && !clicked);
    }

    public void clickPublishBtn() {
        click(this.postBtn);
    }
}
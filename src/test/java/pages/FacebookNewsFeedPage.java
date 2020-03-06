package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FacebookNewsFeedPage extends BasePage {

    private WebDriver driver;


    @FindBy(how = How.XPATH, using = "//span[text()='Crear publicación']")
    private WebElement postBox;

    @FindBy(how = How.XPATH, using = "//div[@aria-autocomplete='list']")
    private WebElement postInput;

    @FindBy(how = How.XPATH, using = "//button//span[text()='Publicar']")
    private WebElement postBtn;

    public FacebookNewsFeedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //clicks the postbox making it editable.
    public void clickCreatePost(){
        click(this.postBox);
    }

    //clicks on the input to type the message
    //todo fix the try catch
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
        int attempt = 0;
        boolean clicked = false;
        do {
            try {
                click(this.postBtn);
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
    //todo add validation to created post


}

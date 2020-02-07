package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(WebElement webElement){
        System.out.println("Clicking on button.");
        webElement.click();
    }

    protected void enterText(WebElement webElement, String text){
        System.out.println("Entering text:" + text);
        webElement.sendKeys(text);
    }
}
package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import pages.FacebookNewsFeedPage;


public class FacebookTests extends BaseTest {

    FacebookLoginPage facebookLoginPage;
    FacebookNewsFeedPage facebookNewsFeedPage;

    @Test(priority = 1)
    public void loginTest() {
        facebookLoginPage.enterEmail("fbautotest1@gmail.com");
        facebookLoginPage.enterPassword("Testing1234!");
        facebookLoginPage.clickSignInButton();
    }

    @Test (priority = 2)
    public void createPost(){
        facebookNewsFeedPage.clickCreatePost();
        facebookNewsFeedPage.createPost("I created a new Post!");
        facebookNewsFeedPage.clickPublishBtn();
    }
}
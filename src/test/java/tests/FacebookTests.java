package tests;

import base.BaseTest;
import org.junit.Test;

public class FacebookTests extends BaseTest {

    @Test
    public void loginTest() {
        facebookLoginPage.enterEmail("fbautotest1@gmail.com");
        facebookLoginPage.enterPassword("Testing1234!");
        facebookLoginPage.clickSignInButton();
    }
}
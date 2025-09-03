package com.phonebooks.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTests(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User()
                .setEmail("pro101kod@gmail.com")
                .setPassword("Wer533des!"));
        clickOnLoginButton();
        Assert.assertTrue(isElementPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        clickOnLoginLink();
        fillRegisterLoginForm( new User()
                .setPassword("Wer533des!"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }


}

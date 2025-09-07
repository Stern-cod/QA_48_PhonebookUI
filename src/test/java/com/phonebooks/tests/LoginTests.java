package com.phonebooks.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTests(){
        app.getUser().clickOnLoginLink();;
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("pro101kod@gmail.com")
                .setPassword("Wer533des!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSingOutPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm( new User()
                .setPassword("Wer533des!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }


}

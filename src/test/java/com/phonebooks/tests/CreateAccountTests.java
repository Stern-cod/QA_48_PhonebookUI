package com.phonebooks.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

     @Test (enabled = false)
    public void UserRegistrationPositiveTest(){
        clickOnLoginLink();
        //type(By.name("email"), "pro@gmail.com");
        //type(By.name("password"), "Wer533des!");
        //click on Registration button
        //click(By.name("registration"));
        //verify SignOut is displayed
        Assert.assertTrue(isElementPresent());
    }

    @Test
    public void existedRegistrationPositiveTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("pro101kod@gmail.com").setPassword("Wer533des!"));
        clickRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());
    }


}
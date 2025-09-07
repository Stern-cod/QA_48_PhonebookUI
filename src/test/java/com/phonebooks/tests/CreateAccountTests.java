package com.phonebooks.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{
    SoftAssert softAssert = new SoftAssert();

     @Test (enabled = false)
    public void newUserRegistrationPositiveTest(){
        app.getUser().clickOnLoginLink();;
        //type(By.name("email"), "pro@gmail.com");
        //type(By.name("password"), "Wer533des!");
        //click on Registration button
        //click(By.name("registration"));
        //verify SignOut is displayed
        app.getUser().fillRegisterLoginForm(new User()
                 .setEmail("pro101kod@gmail.com")
                 .setPassword("Wer533des!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSingOutPresent());
    }

    @Test
    public void existedRegistrationPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("pro101kod@gmail.com")
                .setPassword("Wer533des!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

    @Test
    public void existedRegistrationNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("pro101kodgmail.com")
                .setPassword("Wer533des!"));
        app.getUser().clickOnRegistrationButton();
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }


}
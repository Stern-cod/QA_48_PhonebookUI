package com.phonebooks.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User()
                .setEmail("pro101kod@gmail.com")
                .setPassword("Wer533des!"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        clickOnAddLink();
        fillContactForm(new Contact().setName("Bob")
                .setLastName("Dilan")
                .setPhone("01234567890")
                .setEmail("Bob@gmail.com")
                .setAddress("Haifa")
                .setDescription("Dest"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Bob"));


    }

    @AfterMethod
    public void postCondition(){
         deleteContact();
    }

}

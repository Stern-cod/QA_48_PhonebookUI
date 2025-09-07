package com.phonebooks.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("pro101kod@gmail.com")
                .setPassword("Wer533des!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Bob")
                .setLastName("Dilan")
                .setPhone("01234567890")
                .setEmail("Bob@gmail.com")
                .setAddress("Haifa")
                .setDescription("Dest"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Bob"));


    }

    @AfterMethod
    public void postCondition(){
         app.getContact().deleteContact();
    }

}

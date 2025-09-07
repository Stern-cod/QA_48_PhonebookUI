package com.phonebooks.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("pro101kod@gmail.com")
                .setPassword("Wer533des!"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Bob")
                .setLastName("Dilan")
                .setPhone("01234567890")
                .setEmail("Bob@gmail.com")
                .setAddress("Haifa")
                .setDescription("Dest"));
        app.getContact().clickOnSaveButton();

    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter= app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1 );

    }


}

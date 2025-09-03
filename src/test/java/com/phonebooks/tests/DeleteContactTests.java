package com.phonebooks.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User()
                .setEmail("pro101kod@gmail.com")
                .setPassword("Wer533des!"));
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm(new Contact().setName("Bob")
                .setLastName("Dilan")
                .setPhone("01234567890")
                .setEmail("Bob@gmail.com")
                .setAddress("Haifa")
                .setDescription("Dest"));
        clickOnSaveButton();

    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000);
        int sizeAfter= sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1 );

    }


}

package com.phonebooks.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test (enabled = false)
    public void UserRegistrationPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "pro" + i + "@gmail.com");
        type(By.name("password"), "Wer533des!");
        //click on Registration button
        click(By.name("registration"));
        //verify SignOut is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void existedRegistrationPositiveTest(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "pro101kod@gmail.com");
        type(By.name("password"), "Wer533des!");
        click(By.name("registration"));
        //verify SignOut is displayed
        Assert.assertTrue(isAlertDisplayed());
    }


}
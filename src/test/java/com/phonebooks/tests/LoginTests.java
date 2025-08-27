package com.phonebooks.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTests(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "pro101kod@gmail.com");
        type(By.name("password"), "Wer533des!");
        click(By.name("login"));
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }



}

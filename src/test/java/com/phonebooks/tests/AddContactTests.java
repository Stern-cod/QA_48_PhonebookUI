package com.phonebooks.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "pro101kod@gmail.com");
        type(By.name("password"), "Wer533des!");
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest(){
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"),"Bob1");
        type(By.cssSelector("input:nth-child(2)"),"Dilan");
        type(By.cssSelector("input:nth-child(3)"),"01234567890");
        type(By.cssSelector("input:nth-child(4)"),"Bob@gmail.com");
        type(By.cssSelector("input:nth-child(5)"),"Haifa");
        type(By.cssSelector("input:nth-child(6)"),"Dest");
        click(By.cssSelector(".add_main__1tbl_ button"));
        Assert.assertTrue(isContactAdded("Bob"));


    }

    private boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for(WebElement element:contacts){
            if(element.getText().contains(text))
                return true;
        }
        return false;
    }

    @AfterMethod
    public void postCondition(){
        //driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        // driver.findElement(By.xpath("//button[.='Remove']")).click();
        click(By.xpath("//button[.='Remove']"));
    }

}

package com.phonebooks.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "pro101kod@gmail.com");
        type(By.name("password"), "Wer533des!");
        click(By.name("login"));

        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"),"Bob2");
        type(By.cssSelector("input:nth-child(2)"),"Dilan");
        type(By.cssSelector("input:nth-child(3)"),"01234567890");
        type(By.cssSelector("input:nth-child(4)"),"Bob@gmail.com");
        type(By.cssSelector("input:nth-child(5)"),"Haifa");
        type(By.cssSelector("input:nth-child(6)"),"Dest");
        click(By.cssSelector(".add_main__1tbl_ button"));

    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter= sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1 );

    }

    private int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements((By.cssSelector(".contact-item_card__2SOIM"))).size();
        }
        return 0;
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

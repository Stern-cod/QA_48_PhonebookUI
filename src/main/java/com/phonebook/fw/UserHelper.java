package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSingOutPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isErrorMessagePresent() {
         return  isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }

    public boolean isHomeComponentPresent(){
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }

    public void clickOnLoginButton() { click(By.name("login"));
    }
}

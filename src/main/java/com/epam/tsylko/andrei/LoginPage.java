package com.epam.tsylko.andrei;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static String URL_MATCH = "phpmyadmin";

    private WebDriver driver;

    @FindBy(id ="input_username")
    private WebElement username;

    @FindBy(id="input_password")
    private WebElement password;

    @FindBy(id = "input_go")
    private WebElement go;

    @FindBy(className = "icon ic_s_error")
    private WebElement logginError;

    public LoginPage(WebDriver driver) {

        if(!driver.getCurrentUrl().contains(URL_MATCH)){
            throw new IllegalStateException("This is not the page you are expected");
        }

        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    private void loggingUser(User user){
        username.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        go.submit();
    }

    public HomePage loggingUserSuccess(User user){
        loggingUser(user);
        return new HomePage(driver);
    }

    public LoginPage loggingUserError(User user){
        loggingUser(user);
        return new LoginPage(driver);
    }

    public LoginPage checkErrorMessage(String errorMessage){
        Assert.assertTrue("Error message should be present",
                logginError.isDisplayed());
        Assert.assertTrue("Error message should contains " + errorMessage,
                logginError.getText().contains(errorMessage));
        return this;
    }

}

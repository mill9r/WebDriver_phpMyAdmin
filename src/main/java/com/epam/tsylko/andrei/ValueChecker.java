package com.epam.tsylko.andrei;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValueChecker {

    private WebDriver driver;

    @FindBy(xpath = ".//*[@id='page_content']/div[1]/div[2]/code/div/span[11]")
    private WebElement id;
    @FindBy(xpath = ".//*[@id='page_content']/div[1]/div[2]/code/div/span[12]")
    private WebElement login;
    @FindBy(xpath = ".//*[@id='page_content']/div[1]/div[2]/code/div/span[13]")
    private WebElement password;
    @FindBy(xpath = ".//*[@id='page_content']/div[1]/div[2]/code/div/span[14]")
    private WebElement email;
    @FindBy(xpath = ".//*[@id='page_content']/div[1]/div[2]/code/div/span[15]")
    private WebElement name;
    @FindBy(xpath = ".//*[@id='page_content']/div[1]/div[2]/code/div/span[16]")
    private WebElement remember;

    public ValueChecker(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkTablesRows(RowsValue row) {

        Assert.assertEquals("'"+row.getLogin()+"'", login.getText());
        Assert.assertEquals("'"+row.getPassword()+"'", password.getText());
        Assert.assertEquals("'"+row.getEmail()+"'", email.getText());
        Assert.assertEquals("'"+row.getName()+"'", name.getText());
        Assert.assertEquals("'"+row.getRemember()+"'", remember.getText());
    }
}

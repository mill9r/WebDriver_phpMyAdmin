package com.epam.tsylko.andrei;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableChecker {
    private static String ID = "u_id";
    private static String LOGIN = "u_login";
    private static String PASSWORD = "u_password";
    private static String EMAIL = "u_email";
    private static String NAME = "u_name";
    private static String REMEMBER = "u_remember";

    private WebDriver driver;

    @FindBy(xpath = ".//*[@id='tablestructure']/tbody/tr[1]/th/label")
    private WebElement id;
    @FindBy(xpath = ".//*[@id='tablestructure']/tbody/tr[2]/th/label")
    private WebElement login;
    @FindBy(xpath = ".//*[@id='tablestructure']/tbody/tr[3]/th/label")
    private WebElement password;
    @FindBy(xpath = ".//*[@id='tablestructure']/tbody/tr[4]/th/label")
    private WebElement email;
    @FindBy(xpath = ".//*[@id='tablestructure']/tbody/tr[5]/th/label")
    private WebElement name;
    @FindBy(xpath = ".//*[@id='tablestructure']/tbody/tr[6]/th/label")
    private WebElement remember;

    public TableChecker(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkTablesFields() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table_strucuture_id")));
        Assert.assertEquals(ID, id.getText());
        Assert.assertEquals(LOGIN, login.getText());
        Assert.assertEquals(PASSWORD, password.getText());
        Assert.assertEquals(EMAIL, email.getText());
        Assert.assertEquals(NAME, name.getText());
        Assert.assertEquals(REMEMBER, remember.getText());
    }

}

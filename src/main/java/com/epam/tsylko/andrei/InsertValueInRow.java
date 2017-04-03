package com.epam.tsylko.andrei;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsertValueInRow {

    private WebDriver driver;

    @FindBy(id = "field_2_3")
    private WebElement login;
    @FindBy(id = "field_3_3")
    private WebElement password;
    @FindBy(id = "field_4_3")
    private WebElement email;
    @FindBy(id = "field_5_3")
    private WebElement name;
    @FindBy(id = "field_6_3")
    private WebElement remember;

    public InsertValueInRow(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setLogin(String login) {
        this.login.sendKeys(login);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setName(String name) {
        this.name.sendKeys(name);
    }

    public void setRemember(String remember) {
        this.remember.sendKeys(remember);
    }

    public void setValue(RowsValue row) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='topmenu']/li[5]/a")));
        this.setName(row.getName());
        this.setEmail(row.getEmail());
        this.setLogin(row.getLogin());
        this.setPassword(row.getPassword());
        this.setRemember(row.getRemember());
    }
}

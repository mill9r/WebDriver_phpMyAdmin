package com.epam.tsylko.andrei;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableCreator {

    private WebDriver driver;

    @FindBy(name = "table")
    private WebElement tableName;


    @FindBy(name = "num_fields")
    private WebElement fieldsNumber;


    public TableCreator(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }


    public void setTableName(String tableName) {
       this.tableName.sendKeys(tableName);
    }

    public void setFieldsNumber(String fieldsNumber) {
        this.fieldsNumber.clear();
        this.fieldsNumber.sendKeys(fieldsNumber);
    }

    public void submit(){
        tableName.submit();
    }


    public void createTable(String tableName, String fieldsNumber){
        this.setTableName(tableName);
        this.setFieldsNumber(fieldsNumber);
        this.submit();
    }
}

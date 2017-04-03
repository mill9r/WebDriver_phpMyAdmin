package com.epam.tsylko.andrei;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DataBaseCreator {

    private WebDriver driver;

    @FindBy(id = "text_create_db")
    private WebElement dataBaseName;

    @FindBy(name = "db_collation")
    private WebElement dataBaseEncoding;

    @FindBy(id = "buttonGo")
    private WebElement buttonGo;

//Page Factory doesn't support select
    public Select getSelectOptions() {
        return new Select(dataBaseEncoding);
    }


    public DataBaseCreator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setDataBaseName(String name) {
        dataBaseName.sendKeys(name);
    }

    public void setDataBaseEncoding(Encoding encoding) {
        System.out.println(encoding.getEncoding());
        getSelectOptions().selectByValue(encoding.getEncoding());
    }

    public void createDb(){
        buttonGo.click();
    }


    public void createDb(String name, Encoding encoding ){
        this.setDataBaseName(name);
        this.setDataBaseEncoding(encoding);
        this.createDb();
    }


}

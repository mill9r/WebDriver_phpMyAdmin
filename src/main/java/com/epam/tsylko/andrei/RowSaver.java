package com.epam.tsylko.andrei;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RowSaver {


    private WebDriver driver;

    @FindBy(name = "do_save_data")
    private WebElement button;

    public RowSaver(WebDriver driver) {
        PageFactory.initElements(driver,this);

        this.driver = driver;
    }
    public void clickCreateRow(){
        button.submit();
    }
}

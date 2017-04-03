package com.epam.tsylko.andrei;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValueSaver {

    private WebDriver driver;


    @FindBy(xpath = ".//*[@id='insertForm']/table[1]/tfoot/tr/th/input")
    private WebElement go;


    public ValueSaver(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void submitValue() {
        go.submit();
    }


}

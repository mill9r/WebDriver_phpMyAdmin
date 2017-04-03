package com.epam.tsylko.andrei;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertPage {

    private WebDriver driver;

    @FindBy(xpath = ".//*[@id='topmenu']/li[5]/a")
    private WebElement element;

    public InsertPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void selectIndexPage(){
        element.click();
    }
}

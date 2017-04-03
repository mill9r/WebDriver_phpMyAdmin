package com.epam.tsylko.andrei;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

//    private static String HOME_PAGE = "index.php";

    private WebDriver driver;

    @FindBy(className = "tab")
    private WebElement dataBase;

    public HomePage(WebDriver driver) {

//        if(!driver.getCurrentUrl().contains(HOME_PAGE)){
//            throw new IllegalStateException("This is not the page you are expected");
//        }
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void clickCreateDB(){
        dataBase.click();
    }

}

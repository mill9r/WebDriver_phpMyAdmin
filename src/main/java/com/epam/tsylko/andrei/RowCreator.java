package com.epam.tsylko.andrei;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RowCreator {

    private static String FIELD = "field_";

    private WebDriver driver;

    private int row;
    private WebElement name;
    private Select type;
    private WebElement length;
    private Select index;
    private WebElement ai;
    private WebElement button;
    private Row ri;

    public RowCreator(WebDriver driver, int row, Row rowInstance) {
        this.driver = driver;
        this.row = row;
        this.ri = rowInstance;
    }

    public void setName(String name) {
        String field = FIELD + row + "_1";
        this.name = driver.findElement(By.id(field));
        this.name.sendKeys(name);

    }

    public void setType(Type type) {
        String field = FIELD + row + "_2";
        this.type = new Select(driver.findElement(By.id(field)));
        this.type.selectByVisibleText(type.toString());
    }

    public void setLength(String length) {
        String field = FIELD + row + "_3";
        this.length = driver.findElement(By.id(field));
        this.length.sendKeys(length);
    }

    public void setIndex(Index index) {
        String field = FIELD + row + "_7";
        this.index = new Select(driver.findElement(By.id(field)));
        this.index.selectByVisibleText(index.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button = driver.findElement(By.xpath("html/body/div[9]/div[3]/div/button[1]"));
        button.click();
    }

    public void setAi(Boolean ai) {
        if (ai) {
            String field = FIELD + row + "_8";
            this.ai = driver.findElement(By.id(field));
            this.ai.click();
        }
    }

    public void createSimpleRow(String name, Type type, String length) {
        setName(name);
        setType(type);
        setLength(length);
    }

    public void createRow(String name, Type type, String length, Index index, Boolean ai) {
        setName(name);
        setType(type);
        setLength(length);
        setIndex(index);
        setAi(ai);
    }

    public void initRow() {
        if (ri.getIndex() != null) {
            createRow(ri.getName(), ri.getType(), ri.getLength(), ri.getIndex(), ri.isAI());
        } else {
            createSimpleRow(ri.getName(), ri.getType(), ri.getLength());
        }
    }

}

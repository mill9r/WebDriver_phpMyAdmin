package com.epam.tsylko.andrei;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestTask {

    String base_url = "http://localhost/phpmyadmin";
    static WebDriver driver = null;
    static StringBuffer verficationErrors = new StringBuffer();


    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:\\gekdriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
        driver = null;
        String verificationErrorsString = verficationErrors.toString();
        if (!"".equals(verificationErrorsString)) {
            Assert.fail(verificationErrorsString);
        }
    }


    @Test
    public void testAdvance() {
        driver.get(base_url);
        User user = new User("root", "unreal2k3");
        LoginPage page = new LoginPage(driver);
        HomePage home = page.loggingUserSuccess(user);
        home.clickCreateDB();
//        Create DB
        DataBaseCreator dataBaseCreator = new DataBaseCreator(driver);
        dataBaseCreator.createDb("auth", Encoding.UTF);
//        Create Table
        TableCreator tableCreator = new TableCreator(driver);
        tableCreator.createTable("users", "6");
//      Rows in table
        Row rowOne = new Row("u_id", Type.INT, "11", Index.PRIMARY, true);
        Row rowTwo = new Row("u_login",Type.VARCHAR,"255");
        Row rowThree = new Row("u_password",Type.CHAR,"40");
        Row rowFour = new Row("u_email",Type.VARCHAR,"255");
        Row rowFive = new Row("u_name",Type.VARCHAR,"255");
        Row rowSix = new Row("u_remember",Type.CHAR,"40");

        List<Row> list = new ArrayList<>();
        list.add(rowOne);
        list.add(rowTwo);
        list.add(rowThree);
        list.add(rowFour);
        list.add(rowFive);
        list.add(rowSix);

        RowCreator row;
        for (int i = 0; i < list.size(); i++) {
            row = new RowCreator(driver, i, list.get(i));
            row.initRow();
        }

        RowSaver create = new RowSaver(driver);
        create.clickCreateRow();
// Check rows in table
        TableChecker checker = new TableChecker(driver);
        checker.checkTablesFields();

        InsertPage insertPage = new InsertPage(driver);
        insertPage.selectIndexPage();
// Insert value in table
        RowsValue valueOne = new RowsValue("user1","e38ad214943daad1d64c102faec29de4afe9da3d","user1@mail.com","Pupkin","");
        RowsValue valueTwo = new RowsValue("user2","2aa60a8ff7fcd473d321e0146afd9e26df395147","user2@mail.com","Smith","");
        InsertValueInRow insertValueInRow = new InsertValueInRow(driver);
        insertValueInRow.setValue(valueOne);
        ValueSaver saver = new ValueSaver(driver);
        saver.submitValue();
// Check inserted value
        ValueChecker valueChecker = new ValueChecker(driver);
        valueChecker.checkTablesRows(valueOne);

        insertPage.selectIndexPage();
        insertValueInRow.setValue(valueTwo);
        saver.submitValue();
        valueChecker.checkTablesRows(valueTwo);

    }



//    @Test
//    public void deleteTable() {
//        driver.get(base_url);
//        WebElement username = driver.findElement(By.id("input_username"));
//        username.sendKeys("root");
//        WebElement password = driver.findElement(By.id("input_password"));
//        password.sendKeys("unreal2k3");
//        password.submit();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        WebElement db_button = driver.findElement(By.className("tab"));
//        db_button.click();
//
//        WebElement delete_tbl = driver.findElement(By.className("checkall"));
//        delete_tbl.click();
//
//        WebElement drop = driver.findElement(By.xpath(".//*[@id='dbStatsForm']/button"));
//        drop.submit();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
////        WebElement submitB = driver.findElement(By.className("html/body/div[8]/div[3]/div/button[1]"));
////        submitB.click();
//
//    }

}

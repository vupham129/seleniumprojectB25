package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_SelectingDateDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void selectDateDropdown(){
        //3. Select “December 1st, 1992” and verify it is selected.
        //Select year using : visible text
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectYear.selectByVisibleText("1992");

        //Select month using : value attribute
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        selectMonth.selectByValue("11");

        //Select day using : index number
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByIndex(0);

        System.out.println("selectYear.getFirstSelectedOption().isSelected() = " + selectYear.getFirstSelectedOption().isSelected());
        System.out.println("selectMonth.getFirstSelectedOption().isSelected() = " + selectMonth.getFirstSelectedOption().isSelected());
        System.out.println("selectDay.getFirstSelectedOption().isSelected() = " + selectDay.getFirstSelectedOption().isSelected());


        String actualSelectYear = selectYear.getFirstSelectedOption().getText();
        String actualSelectMonth = selectMonth.getFirstSelectedOption().getText();
        String actualSelectDay = selectDay.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectYear,"1992");
        Assert.assertEquals(actualSelectMonth, "December");
        Assert.assertEquals(actualSelectDay, "1");
    }


}

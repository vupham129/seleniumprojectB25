package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleDropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //TC #8: Selecting value from multiple select dropdown
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
    public void multipleDropDownTest(){
        //3. Select all the options from multiple select dropdown.
        WebElement multipleDropDownElm = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select multipleSelectObj = new Select(multipleDropDownElm);

        System.out.println("multipleSelectObj.isMultiple() = " + multipleSelectObj.isMultiple());

        multipleSelectObj.selectByIndex(0);
        multipleSelectObj.selectByValue("js");
        multipleSelectObj.selectByVisibleText("C#");
        multipleSelectObj.selectByIndex(3);
        multipleSelectObj.selectByValue("ruby");
        multipleSelectObj.selectByVisibleText("C");

        //4. Print out all selected values.
       List<WebElement> allSelectedOptions = multipleSelectObj.getAllSelectedOptions();
        System.out.println("allSelectedOptions.size() = " + allSelectedOptions.size());

        for (WebElement eachSelected : allSelectedOptions) {
            System.out.println("eachSelected = " + eachSelected.getText());
        }

        //5. Deselect all values.
        multipleSelectObj.deselectAll();
        List<WebElement> verifyDeselectOptions = multipleSelectObj.getAllSelectedOptions();
        System.out.println("verifyDeselectOptions.size() = " + verifyDeselectOptions.size()); // ==0

    }





}

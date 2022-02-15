package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_VerifyingSimpleDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void simpleDropdownTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        String expectedSimpleDropdownText = "Please select an option";
        WebElement dropdownElm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select simpleDropdown = new Select(dropdownElm);

         WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
         String actualSimpleDropdownText = currentlySelectedOption.getText();

        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdownText);

    }

    @Test
    public void stateSelectionTest(){
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State"

        String expectedStateSelectionText = "Select a State";

        WebElement dropdownElmSS = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateSelection = new Select(dropdownElmSS);

        WebElement defaultSelectedValue = stateSelection.getFirstSelectedOption();
        String actualStateSelectionText = defaultSelectedValue.getText();

        Assert.assertEquals(actualStateSelectionText,expectedStateSelectionText);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}

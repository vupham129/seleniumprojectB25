package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class T5_SelectingStateDropDown {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void stateDropdown() throws InterruptedException {

        //3. Select Illinois
        WebElement dropdownElm = driver.findElement(By.xpath("//select[@id='state']"));
        Select selectObj = new Select(dropdownElm);
        Thread.sleep(3000);
        selectObj.selectByVisibleText("Illinois");
        //4. Select Virginia
        Thread.sleep(3000);
        selectObj.selectByValue("VA");
        //5. Select California
        Thread.sleep(3000);
        selectObj.selectByIndex(5);
        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)
        String actualFinalSelectedText = selectObj.getFirstSelectedOption().getText();

        String expectedSelectedText = "California";
        System.out.println(expectedSelectedText);

        assertEquals(actualFinalSelectedText,expectedSelectedText) ;

    }




}

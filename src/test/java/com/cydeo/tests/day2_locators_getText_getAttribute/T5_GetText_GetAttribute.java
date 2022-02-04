package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_GetText_GetAttribute {
    public static void main(String[] args) {
//        TC #5: getText() and getAttribute() method practice
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://practice.cydeo.com/registration_form
        driver.navigate().to("https://practice.cydeo.com/registration_form");

//        3- Verify header text is as expected:
//        Expected: Registration form
        String expectedHeaderText = "Registration form";
        WebElement headerText = driver.findElement(By.tagName("h2"));
       String actualHeaderText =  headerText.getText();

       if(actualHeaderText.equals(expectedHeaderText)){
           System.out.println("Passed");
       }else{
           System.out.println("Failed");
       }

//        4- Locate “First name” input box
        WebElement firstNameBox = driver.findElement(By.className("form-control"));


//        5- Verify placeholder attribute’s value is as expected:
//        Expected: first name
        String expectedFNText = "first name";
        String actualFNText = firstNameBox.getAttribute("placeholder");

        if(actualFNText.equals(expectedFNText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();

    }
}

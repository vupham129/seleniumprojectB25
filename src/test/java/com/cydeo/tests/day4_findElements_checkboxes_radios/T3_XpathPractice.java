package com.cydeo.tests.day4_findElements_checkboxes_radios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_XpathPractice {
    public static void main(String[] args) {
        //XPATH Practice
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #6: XPATH LOCATOR practice
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2. Go to https://practice.cydeo.com/multiple_buttons
        driver.get("https://practice.cydeo.com/multiple_buttons");

        //3. Click on Button 1
        //4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}

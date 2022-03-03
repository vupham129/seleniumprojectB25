package com.cydeo.tests.practice_ShortVideos;

import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {
    //Mini-Task: CREATE A CLASS à SmartBearUtils
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter
    public static void loginToSmartBear(WebDriver driver){
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username1"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password1"));
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();
    }

}

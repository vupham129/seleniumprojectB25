package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    // This method will login with helpdesk1@cybertekschool.com user when it is called
    public static void crm_login(WebDriver driver){
        //3. Enter valid username
        WebElement userNameInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameInputBox.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButton.click();
    }


    public static void crm_login(WebDriver driver, String userName, String passWord){
        //3. Enter valid username
        WebElement userNameInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameInputBox.sendKeys(userName);

        //4. Enter valid password
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys(passWord);

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButton.click();
    }




}

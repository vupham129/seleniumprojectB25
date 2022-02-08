package com.cydeo.tests.practice_ShortVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_Task2 {
    public static void main(String[] args) {
//        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

//        3- Verify “remember me” label text is as expected:
//        Expected: Remember me on this computer
        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeText = rememberMe.getText();
        String expectedText = "Remember me on this computer";
        if(actualRememberMeText.equals(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

//        4- Verify “forgot password” link text is as expected:
//        Expected: Forgot your password?
        WebElement forgotPW = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPWText = "Forgot your password?";
        String actualForgotPW = forgotPW.getText();
        System.out.println(actualForgotPW);// FORGOT YOUR PASSWORD?

        if(actualForgotPW.equals(expectedForgotPWText)){
            System.out.println("forgot password link text verification PASSED");
        }else{
            System.out.println("forgot password link text verification FAILED");

        }

//                5- Verify “forgot password” href attribute’s value contains expected:
//        Expected: forgot_password=yes
        String attributeValueOfForgotPW = forgotPW.getAttribute("href");
        String expectedAttributeValue = "forgot_password=yes";
        System.out.println(attributeValueOfForgotPW);
        if(attributeValueOfForgotPW.contains(expectedAttributeValue)){
            System.out.println("Attribute value of forgot password PASSED");
        }else{
            System.out.println("Attribute value of forgot password FAILED");
        }

        driver.close();

//        PS: Inspect and decide which locator you should be using to locate web
//        elements.
    }
}

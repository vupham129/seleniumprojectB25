package com.cydeo.tests.practice_ShortVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_Task4 {
    public static void main(String[] args) {
//        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

//        3- Verify “Reset password” button text is as expected:
//        Expected: Reset password
        WebElement resetPWText = driver.findElement(By.className("login-btn"));
        String actualResetPWText = resetPWText.getAttribute("value");
        String expectedResetPWText = "Reset password";
        if(actualResetPWText.equals(expectedResetPWText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();


//        PS: Inspect and decide which locator you should be using to locate web
//        elements.
//                PS2: Pay attention to where to get the text of this button from
    }
}

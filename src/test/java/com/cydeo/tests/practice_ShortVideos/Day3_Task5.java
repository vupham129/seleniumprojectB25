package com.cydeo.tests.practice_ShortVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_Task5 {
    public static void main(String[] args) throws InterruptedException {
//        TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

//        3- Enter incorrect username into login box:
        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        loginBox.sendKeys("incorrect");

//        4- Click to `Reset password` button
        WebElement resetPWButton = driver.findElement(By.className("login-btn"));
        resetPWButton.click();

//        5- Verify “error” label is as expected
//        Expected: Login or E-mail not found
        Thread.sleep(3000);

        WebElement errorLable = driver.findElement(By.className("errortext"));
        String expectedErrorMessage = "Login or E-mail not found";
        String actualErrorMessage = errorLable.getText();

        if(actualErrorMessage.equals(expectedErrorMessage)){
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

package com.cydeo.tests.practice_ShortVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_Task1 {
    public static void main(String[] args) throws InterruptedException {

//        TC #1: NextBaseCRM, locators and getText() practice
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

//        3- Enter incorrect username: “incorrect”
        WebElement userNameBox = driver.findElement(By.name("USER_LOGIN"));
        userNameBox.sendKeys("incorrect");
//        4- Enter incorrect password: “incorrect”
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("incorrect");
//        5- Click to login button.
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();

//        6- Verify error message text is as expected:
//        Expected: Incorrect login or password

        Thread.sleep(5000);

        WebElement errorMessage = driver.findElement(By.className("errortext"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Incorrect login or password";

        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Verification passed");
        }else{
            System.out.println("Verification failed");
        }

        driver.close();
//        PS: Inspect and decide which locator you should be using to locate web
//        elements.


    }
}

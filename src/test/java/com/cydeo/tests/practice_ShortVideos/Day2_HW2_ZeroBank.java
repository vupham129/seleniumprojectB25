package com.cydeo.tests.practice_ShortVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HW2_ZeroBank {
    public static void main(String[] args) {
//        TC #2: Zero Bank header verification
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

//        3. Verify header text
//        Expected: “Log in to ZeroBank”
        String expectedHeaderText = "Log in to ZeroBank";

        WebElement headerText = driver.findElement(By.tagName("h3"));

        String actualHeaderText = headerText.getText();

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification passed");
        }else{
            System.out.println("Header text verification failed");
        }

        driver.close();



    }
}

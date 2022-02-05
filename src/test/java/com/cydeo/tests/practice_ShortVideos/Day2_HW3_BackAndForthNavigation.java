package com.cydeo.tests.practice_ShortVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HW3_BackAndForthNavigation {
    public static void main(String[] args) throws InterruptedException {
//        TC #3: Back and forth navigation
//        1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        2- Go to: https://google.com
        driver.get("https://google.com");

//        3- Click to Gmail from top right.
        WebElement gmailLinkText = driver.findElement(By.linkText("Gmail"));
        gmailLinkText.click();

//        4- Verify title contains:
//        Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }

        Thread.sleep(3000);

//        5- Go back to Google by using the .back();
        driver.navigate().back();

//        6- Verify title equals:
//        Expected: Google
            String expectedTitle1 = "Google";
            String actualTitle1 = driver.getTitle();

            if(actualTitle1.equals(expectedTitle1)){
                System.out.println("Title is Google. PASSED");
            }else{
                System.out.println("Title is: "+actualTitle1+". FAILED");
            }


            driver.close();

    }
}

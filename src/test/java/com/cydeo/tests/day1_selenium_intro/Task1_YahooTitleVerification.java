package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {

        //TC #1: Yahoo Title Verification
        //1.Open Chrome browser
        //2.Go to https://www.yahoo.com
        //3.Verify title:
        //Expected: Yahoo

        // set up the browser driver
        WebDriverManager.chromedriver().setup();
        // open chrome browser
        WebDriver driver = new ChromeDriver();
        // go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");
        // make our page fullscreen
        driver.manage().window().maximize();
        // verify title:
        // expected: "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        // actual title comes from the browser
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification passed!");
        }else{
            System.out.println("Title is not as expected. Verification failed!");
        }


























    }
}

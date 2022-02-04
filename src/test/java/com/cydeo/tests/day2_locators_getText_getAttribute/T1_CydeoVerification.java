package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // go to "https://practice.cydeo.com"
        driver.get("https://practice.cydeo.com");

        // maximize the webpage
        driver.manage().window().maximize();

        // stop for 2 seconds
        Thread.sleep(2000);

        // verify URL contains. expected: cydeo

        String currentURL = driver.getCurrentUrl();
        if(currentURL.contains("cydeo")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        //Verify title: expected: Practice

        String currentTitle = driver.getTitle();

        if(currentTitle.equals("Practice")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        // close after done
        driver.close();













    }


}

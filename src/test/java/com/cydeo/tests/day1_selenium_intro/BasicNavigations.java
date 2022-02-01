package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1- set up the browser driver
        WebDriverManager.chromedriver().setup();

        //2-Create instance of the Selenium WebDriver
        // This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        // maximize the page
        driver.manage().window().maximize();


        //3- go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL =  driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);


        //stop code execution for 3 seconds

        Thread.sleep(3000);


        //use selenium to navigate back
        driver.navigate().back();

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate forward
        driver.navigate().forward();

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate refresh
        driver.navigate().refresh();

        // use navigate().to():
        driver.navigate().to("https://www.google.com");


        //get the current title after getting the google page
        currentTitle = driver.getTitle();


        //System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("currentTitle = " + currentTitle);

        // Get the current URL using Selenium
        currentURL =  driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);



    }


}

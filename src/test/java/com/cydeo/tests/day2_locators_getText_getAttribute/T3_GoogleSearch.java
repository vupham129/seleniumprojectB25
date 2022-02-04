package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {
        //  TC#3: Google search
        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //  3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple" + Keys.ENTER);
        //Keys.ENTER: will press enter after the search


//        System.out.println("searchBox.getTagName() = " + searchBox.getTagName());
//        System.out.println(searchBox.getAttribute("class"));
//        System.out.println(searchBox.getAttribute("type"));
//        System.out.println(searchBox.getAttribute("maxLength"));
//        System.out.println(searchBox.getAttribute("title"));
//        System.out.println(searchBox.getAttribute("value"));
        // 4- Click google search button
       // WebElement searchButton = driver.findElement(By.name("btnK"));
        //searchButton.submit();

        // 5- Verify title:
        // Expected: Title should start with “apple” word

        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

        driver.close();


    }
}

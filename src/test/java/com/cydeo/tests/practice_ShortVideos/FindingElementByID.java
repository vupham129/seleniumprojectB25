package com.cydeo.tests.practice_ShortVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElementByID {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://yahoo.com");

        // maximize the browser
        driver.manage().window().maximize();

        // identify and save the element
        WebElement inputBox = driver.findElement(By.id("ybar-sbq"));

        // enter text Hello into the input box
        inputBox.sendKeys("Hello");

        // click on search button
        WebElement searchBtn = driver.findElement(By.id("ybar-search"));
        searchBtn.click();

        Thread.sleep(3000);
        // get title of the page
        String pageTitle = driver.getTitle();

        System.out.println("pageTitle = " + pageTitle);


















    }
}

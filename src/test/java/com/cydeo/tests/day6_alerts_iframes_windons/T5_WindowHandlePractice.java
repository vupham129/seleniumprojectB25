package com.cydeo.tests.day6_alerts_iframes_windons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowHandlePractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1 Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3. Go to: https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void window_test(){
        //4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle, expectedTitle);

       //5. Click to: “Click Here” link
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[@target='_blank']"));
        clickHereBtn.click();


        //6. Switch to new Window.
        // storing main page's window handle
        String mainHandle = driver.getWindowHandle();
        String newWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(newWindowHandle);

        //7. Assert: Title is “New Window”
        String expectedTitleForNewWindow = "New Window";
        String actualTitleNW = driver.getTitle();
        Assert.assertEquals(actualTitleNW,expectedTitle);

    }

    @Test
    public void multiple_window_test(){

        //Storing the main page's window handle as string is
        // good practice for future re-usable purposes
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title before click: " + actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));

        clickHereLink.click();



        //6. Switch to new Window.
        for(String each: driver.getWindowHandles()){

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());

        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitleAfterClick);

        System.out.println("Title after click: " + actualTitle);

    }
}
//TC #5: Window Handle practice
//
//1. Create a new class called: T5_WindowsPractice
//2. Create new test and make set ups
//3. Go to : https://practice.cydeo.com/windows

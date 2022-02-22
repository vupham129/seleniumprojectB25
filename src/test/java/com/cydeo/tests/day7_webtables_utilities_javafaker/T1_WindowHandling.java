package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void window_handling_test(){
        //TC #1: Window Handle practice
        //1. Create new test and make set ups
        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");
        String currentHandle = driver.getWindowHandle();

        //3. Copy and paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> allHandles = driver.getWindowHandles();
        for (String eachHandle : allHandles) {
            driver.switchTo().window(eachHandle);
            System.out.println("Current url: " + driver.getCurrentUrl()); // all of the four browsers
           // System.out.println("Current title: "+driver.getTitle());
            if(driver.getCurrentUrl().contains("etsy")){
                break; // if the current URl has Etsy then stop at this page by using break keyword.
            }

        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Lines to be pasted:
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
    }


}

package com.cydeo.tests.practice_ShortVideos;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TaskFindElements {
    public WebDriver driver;
    //  TC #1: Checking the number of links on the page
    @BeforeMethod
     public void setup(){
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env2"));
    }    
    
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    
    @Test
    public void linksTest(){
        //3. Count the number of the links on the page and verify
        //Expected: 325
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int actualCount = links.size();
        int expectedCount = 325;
        System.out.println("actualCount = " + actualCount);
        Assert.assertEquals(actualCount,expectedCount);

        //TC #2: Printing out the texts of the links on the page
        //3. Print out all of the texts of the links on the page
        for (WebElement eachLink : links) {
            try{
                System.out.println("each link text: "+eachLink.getText());
            }catch (StaleElementReferenceException e){
            }
        }

        //TC #3: Counting the number of links that does not have text
        //3. Count the number of links that does not have text and verify
        //Expected: 228
        int count =0;
        for (WebElement link : links) {
            try{
                if(link.getText().isEmpty()){
                    count++;
                }
            }catch(StaleElementReferenceException e){
            }
        }
        System.out.println("count = " + count);
        Assert.assertTrue(count==228);

    }

}

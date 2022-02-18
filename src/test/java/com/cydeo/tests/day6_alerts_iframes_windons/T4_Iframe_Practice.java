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

public class T4_Iframe_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1 Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void iframe_test(){
        //4. Assert: “Your content goes here.” Text is displayed.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe); // have to switch from html parent to ifram html

        WebElement iframeDisplay = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        System.out.println("iframeDisplay.isDisplayed() = " + iframeDisplay.isDisplayed()); // true
        Assert.assertTrue(iframeDisplay.isDisplayed(), "Result is Not displayed on the text box");
       String actualIframeDisplayText =  iframeDisplay.getText();
       String expectedIframeDisplayText = "Your content goes here.";
       Assert.assertEquals(actualIframeDisplayText,expectedIframeDisplayText);


        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        WebElement textDisplayParentHTML = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String actualDisplayText = textDisplayParentHTML.getText();
        String expectedText = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualDisplayText,expectedText);


    }





}

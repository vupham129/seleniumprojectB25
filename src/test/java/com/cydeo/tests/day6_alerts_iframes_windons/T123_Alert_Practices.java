package com.cydeo.tests.day6_alerts_iframes_windons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class T123_Alert_Practices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1 Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void alert_test1(){
        //3. Click to “Click for JS Alert” button
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickForJSAlert.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed
        WebElement actualResultElm = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        String actualResultText = actualResultElm.getText();
        String expectedResultText = "You successfully clicked an alert";

        assertEquals(actualResultText,expectedResultText);

        Assert.assertTrue(actualResultElm.isDisplayed(), "Result text is NOT displayed");

    }

    @Test
    public void alert_test2(){
        //3. Click to “Click for JS Confirm” button
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickForJSConfirm.click();

        // 4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // 5. Verify “You clicked: Ok” text is displayed.
        WebElement actualElm = driver.findElement(By.xpath("//p[text()='You clicked: Ok']"));
        String actualText = actualElm.getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(actualText,expectedText);

        Assert.assertTrue(actualElm.isDisplayed(), "Result text is NOT displayed");


    }

    @Test
    public void alert_test3(){
        //3. Click to “Click for JS Prompt” button
        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickForJSPrompt.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        WebElement actualElm = driver.findElement(By.xpath("//p[text()='You entered: hello']"));
        String actualText = actualElm.getText();
        String expectedText = "You entered: hello";

        Assert.assertEquals(actualText,expectedText);

        Assert.assertTrue(actualElm.isDisplayed(), "Result text is NOT displayed");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}

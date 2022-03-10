package com.cydeo.tests.day11_actions_jvexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll {
    //TC #7: Scroll using JavascriptExecutor
    //  1- Open a chrome browser
    @Test
    public void scrollTest(){
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");
        // Create javascript executor object
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //3- Scroll down to “Cydeo” link
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        jse.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
        //        4- Scroll up to “Home” link
        BrowserUtils.sleep(2);
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        jse.executeScript("arguments[0].scrollIntoView(true)", homeLink);

        Driver.closeDriver();
    }


}

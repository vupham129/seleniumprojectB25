package com.cydeo.utilities;

/*
In this class only general utility methods that are not related to some specific page
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int second and execute Thread.sleep for given duration
     */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }

    // This method accepts 3 arguments
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){

        Set<String> allHandles = driver.getWindowHandles();
        for (String eachHandle : allHandles) {
            driver.switchTo().window(eachHandle);
            System.out.println("Current url: " + driver.getCurrentUrl()); // all of the four browsers
            if(driver.getCurrentUrl().contains(expectedInUrl)){
                break; // if the current URl has Etsy then stop at this page by using break keyword.
            }
        }
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    // This method accepts a String expectedTitle and Asserts if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    /*
    Creating a utility method for ExplicitWait, so we don't have to repeat the lines
     */
    public static void waitForInvisibilityOf(WebElement webElement){
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }






}
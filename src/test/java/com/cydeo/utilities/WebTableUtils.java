package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {
    //Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date
    //as a String.

    public static String returnOrderDate(WebDriver driver, String customerName){
        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";

        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        return customerDateCell.getText();
    }
    public static String returnOrderDate2(WebDriver driver, String customerName){

        return driver.findElement(By.xpath("//td[.='"+customerName+"']/following-sibling::td[3]")).getText();
    }

    //Method #2 info:
    //• Name: orderVerify ()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //• Arg3: String expectedOrderDate
    //This method should accept above mentioned arguments and internally assert
    //expectedOrderDate matching actualOrderDate
    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate){
        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";

        WebElement customerDateCell = driver.findElement(By.xpath(locator));

        String actualOrderDate = customerDateCell.getText();

        Assert.assertEquals(actualOrderDate,expectedOrderDate);


    }

    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/tables
    //3- Write custom method:
    //• Method name: getTableGetEmail()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String tableNum
    //• Arg3: String firstName
    public static void getTableGetEmail(WebDriver driver, String tableNum, String firstName){

        WebElement table1 = driver.findElement(By.xpath("//table[@id='"+tableNum+"']"));
        WebElement firstNameCell = driver.findElement(By.xpath("//table[@id='"+tableNum+"']//tbody//tr//td[.='"+firstName+"']"));
        WebElement emailCell = driver.findElement(By.xpath("//table[@id='"+tableNum+"']//tbody//tr//td[.='"+firstName+"']/../td[3]"));
        String actualEmailResult = emailCell.getText();
        System.out.println(actualEmailResult);

    }



}

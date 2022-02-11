package com.cydeo.tests.day4_findElements_checkboxes_radios;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_Checkboxes {
    public static void main(String[] args) throws InterruptedException {
        //Practice: Checkboxes
        //1. Go to https://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        // locate where is the checkbox 1
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        System.out.println("checkbox1.isSelected(), expecting false = " + checkbox1.isSelected());// false

        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        System.out.println("checkbox2.isSelected(), expecting true = " + checkbox2.isSelected());//true

        //4. Click checkbox #1 to select it.
        Thread.sleep(2000);
        checkbox1.click(); // checkbox 1 will be selected

        //5. Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkbox2.click(); // checkbox 2 will be unselected

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected(), expecting true = " + checkbox1.isSelected());// true

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected(), expecting false = " + checkbox2.isSelected());//false

        driver.close();

    }
}

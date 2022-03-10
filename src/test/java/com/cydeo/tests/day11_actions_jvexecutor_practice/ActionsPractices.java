package com.cydeo.tests.day11_actions_jvexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class ActionsPractices {

    @Test
    public void task4_and_task5_test() {

        //TC #4: Scroll practice
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");
        //3- Scroll down to “Powered by CYDEO”
        WebElement powerByCydeo = Driver.getDriver().findElement(By.linkText("CYDEO"));
        //4- Scroll using Actions class “moveTo(element)” method
        // Create actions object by using Actions class
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(powerByCydeo).pause(4000).perform();

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
       // WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();



    }
}

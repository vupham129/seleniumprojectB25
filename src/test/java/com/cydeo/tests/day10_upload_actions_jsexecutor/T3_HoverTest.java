package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_HoverTest extends TestBase {
    //TC #3: Hover Test
    @Test
    public void hover_test(){
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        //Locate all images under here:
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        //Locate all "user" texts under here:
        WebElement nameOfImg1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement nameOfImg2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement nameOfImg3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));

        //2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(img1).perform();
        //3. Assert:
        //a. “name: user1” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(nameOfImg1.isDisplayed());
        WebElement viewProfileImg1 = Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[1]"));
        Assert.assertTrue(viewProfileImg1.isDisplayed());

        //4. Hover over to second image
        actions.moveToElement(img2).perform();
        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(nameOfImg2.isDisplayed());
        WebElement viewProfileImg2 = Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[2]"));
        Assert.assertTrue(viewProfileImg2.isDisplayed());

        //6. Hover over to third image
        actions.moveToElement(img3).perform();
        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(nameOfImg3.isDisplayed());
        WebElement viewProfileImg3 = Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[3]"));
        Assert.assertTrue(viewProfileImg3.isDisplayed());


    }

}

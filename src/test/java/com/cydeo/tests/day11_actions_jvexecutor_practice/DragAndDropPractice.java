package com.cydeo.tests.day11_actions_jvexecutor_practice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropPractice {

    //TC #: Drag and drop
    @Test
    public void drag_and_drop_test(){
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.sleep(4);
        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,bigCircle).build().perform();
        actions.moveToElement(smallCircle).clickAndHold().pause(1000).release(bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        BrowserUtils.sleep(2);
        String actualTextBigCircle = Driver.getDriver().findElement(By.xpath("//div[text()='You did great!']")).getText();
        Assert.assertEquals(actualTextBigCircle, "You did great!");

        Driver.closeDriver();

    }



}

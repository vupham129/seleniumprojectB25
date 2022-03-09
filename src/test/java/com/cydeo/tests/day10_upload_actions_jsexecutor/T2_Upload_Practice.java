package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice extends TestBase {
    //TC #2 Upload Test

    @Test
    public void upload_test(){
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String filePath = "C:\\Users\\vupha\\OneDrive\\Desktop\\HTML Class\\cybertruck.jpg";

        //3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);
        fileUpload.sendKeys(filePath);

        WebElement uploadBtn = Driver.getDriver().findElement(By.id("file-submit"));
        uploadBtn.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        BrowserUtils.sleep(2);
        WebElement fileUploadHeader = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertEquals(fileUploadHeader.getText(), "File Uploaded!");
    }
}

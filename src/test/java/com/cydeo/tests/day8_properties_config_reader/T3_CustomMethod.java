package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CustomMethod {
    //TC #3: Create a custom method

    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/tables");
    }

    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }

    @Test
    public void tables_email_test(){
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        WebElement firstNameCell = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr//td[.='Smith']"));
        WebElement emailCell = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr//td[.='Smith']/../td[3]"));
        String expectedEmailResult = "jsmith@gmail.com";
        String actualEmailResult = emailCell.getText();
        Assert.assertEquals(actualEmailResult,expectedEmailResult);
    }

    @Test
    public void test(){
        WebTableUtils.getTableGetEmail(driver, "table1", "Doe");
        WebTableUtils.getTableGetEmail(driver, "table2", "Conway");
    }


}

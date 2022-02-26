package com.cydeo.tests.practice_ShortVideos;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Adam_TC1 {

    //TC 1:
    //1- go to https://practice.cydeo.com/web-tables
    //2- verify cities contains ‘art’ in their names
    //Expected Result:[“Canada”,”US”,”US”]

    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");

    }

    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }

    @Test
    public void cities_contain_art_test(){
        List<WebElement> citiesCell = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr//td[7]"));

        List<String> actualCititesCellText = new ArrayList<>();
        for (String each : actualCititesCellText) {

        }


    }


}

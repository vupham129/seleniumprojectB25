package com.cydeo.tests.vytrackProject;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US67 {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @DataProvider(name="userTruckDriversProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameTruckDrivers1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers2"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers3"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers4"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers5"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers6"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers7"), ConfigurationReader.getProperty("password")}
        };
    }

    @DataProvider(name="userStoreManagerProvider")
    public Object[][] provideData1(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameStoreManager1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager2"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager3"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager4"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager5"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager6"), ConfigurationReader.getProperty("password")}
        };

    }

    @DataProvider(name="userSalesManagerProvider")
    public Object[][] provideData2(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameSalesManager1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameSalesManager2"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameSalesManager3"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameSalesManager4"), ConfigurationReader.getProperty("password")}
        };
    }
    @Test(dataProvider = "userTruckDriversProvider", priority = 1)
    public void truckDriversTest(String username, String password) throws InterruptedException {
        //AC #1: Users should see three columns on the Vehicle Costs page.
        //step1:
        VyTrack_Login.login(driver, username, password);
        Thread.sleep(3);
        WebElement fleetTabElm = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step2:
        fleetTabElm.click();
        //step3:
        WebElement vehicleCostsOption = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[5]/a/span"));
        vehicleCostsOption.click();
        WebElement typeColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[1]//span[.='Type']"));
        Assert.assertTrue(typeColumn.isDisplayed(), "Type column is not displayed on the Vehicle Costs page");
        WebElement totalPriceColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[2]//span[.='Total Price']"));
        Assert.assertTrue(totalPriceColumn.isDisplayed(), "Total price column is not displayed on the Vehicle Costs page");
        WebElement dateColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[3]//span[.='Date']"));
        Assert.assertTrue(dateColumn.isDisplayed(), "Date column is not displayed on the Vehicle Costs page");
        //AC #2: users check the first checkbox to check all the Vehicle Costs
        //There is no first check box on the user TruckDrivers
    }
    @Test(dataProvider = "userStoreManagerProvider", priority = 2)
    public void storeManagerTest(String username, String password){
        //AC #1: Users should see three columns on the Vehicle Costs page.
        //step1:
        VyTrack_Login.login(driver, username, password);
        BrowserUtils.sleep(2);
        Actions actions = new Actions(driver);
        WebElement fleetTabElm = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step2:
        BrowserUtils.sleep(1);
        fleetTabElm.click();
        //step3:
        WebElement vehicleCostsOption = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[5]/a/span"));
        vehicleCostsOption.click();
        WebElement typeColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[2]//span[.='Type']"));
        Assert.assertTrue(typeColumn.isDisplayed(), "Type column is not displayed on the Vehicle Costs page");
        WebElement totalPriceColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[3]//span[.='Total Price']"));
        Assert.assertTrue(totalPriceColumn.isDisplayed(), "Total price column is not displayed on the Vehicle Costs page");
        WebElement dateColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[4]//span[.='Date']"));
        Assert.assertTrue(dateColumn.isDisplayed(), "Date column is not displayed on the Vehicle Costs page");

        //AC #2: users check the first checkbox to check all the Vehicle Costs
        WebElement firstCheckBox = driver.findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']"));
        firstCheckBox.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(firstCheckBox.isSelected(), "First check box is not selected");

    }

    @Test(dataProvider = "userSalesManagerProvider", priority = 3)
    public void salesManagerTest(String username, String password){
        //AC #1: Users should see three columns on the Vehicle Costs page.
        //step1:
        VyTrack_Login.login(driver, username, password);
        BrowserUtils.sleep(2);
        Actions actions = new Actions(driver);
        WebElement fleetTabElm = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step2:
        BrowserUtils.sleep(1);
        fleetTabElm.click();
        //step3:
        WebElement vehicleCostsOption = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[5]/a/span"));
        vehicleCostsOption.click();
        WebElement typeColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[1]//span[.='Type']"));
        Assert.assertTrue(typeColumn.isDisplayed(), "Type column is not displayed on the Vehicle Costs page");
        WebElement totalPriceColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[2]//span[.='Total Price']"));
        Assert.assertTrue(totalPriceColumn.isDisplayed(), "Total price column is not displayed on the Vehicle Costs page");
        WebElement dateColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[3]//span[.='Date']"));
        Assert.assertTrue(dateColumn.isDisplayed(), "Date column is not displayed on the Vehicle Costs page");

        //AC #2: users check the first checkbox to check all the Vehicle Costs
        // There is no first check box on sales manager users

    }




}

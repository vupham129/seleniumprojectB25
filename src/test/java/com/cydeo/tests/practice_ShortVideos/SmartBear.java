package com.cydeo.tests.practice_ShortVideos;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env1"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    //TC #1: Smartbear software link verification
    @Test(priority = 1)
    public void linkVerificationTest(){
        //3. Enter username: “Tester”
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username1"));

        //4. Enter password: “test”
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password1"));

        //5. Click to Login button
        WebElement logInButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        logInButton.click();

        //6. Print out count of all the links on landing page
        //7. Print out each link text on this page
        List<WebElement> landingPage = driver.findElements(By.xpath("//table//tbody//ul//a"));
        int count = 0;
        for (WebElement each : landingPage) {
            if(each.getText().equals("View all orders") ||each.getText().equals("View all products")
                    || each.getText().equals("Order") ){
                count++;
            }
            System.out.println("each link text on the page: "+each.getText()+" ");
        }
        System.out.println(count + " the links on landing page");


    }


    //TC#2: Smartbear software order placing
    @Test(priority = 2)
    public void orderPlacingTest(){
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        SmartBearUtils.loginToSmartBear(driver);

        //6. Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//table//tbody//ul//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select select = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        select.selectByVisibleText("FamilyAlbum");

        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityBox.sendKeys("2");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        WebElement nameBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        nameBox.sendKeys("Alexander Cruz");

        WebElement streetBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        streetBox.sendKeys("1213 Irwindale Dr");

        WebElement cityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityBox.sendKeys("San Francisco");

        WebElement stateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateBox.sendKeys("CA");

        WebElement zipcodeBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipcodeBox.sendKeys("94006");

        //10.Click on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaRadioButton.click();

        //11.Generate card number using JavaFaker
        WebElement cardNumberBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        String cardNumber = "4400556615162237";
        cardNumberBox.sendKeys(cardNumber);
        for (int i = 0; i < cardNumber.length(); i++) {
            char eachCh = cardNumber.charAt(i);
            if(!(Character.isDigit(eachCh))){
                throw new RuntimeException("Your card number should contain only digit");
            }
        }

        WebElement expireDateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDateBox.sendKeys("10/2028");

        //12.Click on “Process”
        WebElement processButton = driver.findElement(By.xpath("//div//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //13.Verify success message “New order has been successfully added.”
        String expectedMessageText = "New order has been successfully added.";
        WebElement actualMessage = driver.findElement(By.xpath("//div//strong"));
        String actualMessageText = actualMessage.getText();

        Assert.assertEquals(actualMessageText,expectedMessageText);



    }








}

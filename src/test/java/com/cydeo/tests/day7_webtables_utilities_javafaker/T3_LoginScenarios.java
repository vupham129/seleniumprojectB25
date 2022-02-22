package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_LoginScenarios {
    //TC #3: Login scenario
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /*
    @DataProvider(name = "logInCredentials")
    public Object[][] provideData(){
        return new Object[][]{
                {"helpdesk1@cybertekschool.com", "UserUser"},
                {"helpdesk2@cybertekschool.com", "UserUser"}
        };
    }

     */

    @Test
    public void crm_login_test(){
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver,"Portal");


    }

    @Test
    public void crm_login_test_3(){
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser");

        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver,"(2) Portal");


    }

    @Test
    public void crm_login_test_2(){
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement userNameInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameInputBox.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        logInButton.click();

        //6. Verify title is as expected:
        //Expected: Portal

        BrowserUtils.verifyTitle(driver,"Portal");


    }





}

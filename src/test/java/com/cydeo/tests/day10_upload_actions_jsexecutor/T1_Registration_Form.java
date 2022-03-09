package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_Registration_Form extends TestBase {
    //TC#1: Registration form confirmation
//Note: Use JavaFaker OR read from configuration.properties file when possible.
//1. Open browser
    @Test
    public void registration_form_test(){
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get("https://practice.cydeo.com/registration_form");
        // Create faker object to be able to use Javafaker
        Faker faker = new Faker();
        //3. Enter first name
        WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.name("lastname"));
        lastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement userName = Driver.getDriver().findElement(By.name("username"));
        userName.sendKeys(faker.name().username());

        //6. Enter email address
        WebElement emailAddress = Driver.getDriver().findElement(By.name("email"));
        emailAddress.sendKeys(faker.internet().emailAddress().replaceAll(".", ""));

        //7. Enter password
        WebElement password = Driver.getDriver().findElement(By.name("password"));
        password.sendKeys(faker.numerify("##########"));
        // password.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement inputPhone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();

        //10.Enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //faker.number().numberBetween(2004, 1920)
        inputBirthday.sendKeys("03/08/2000");

        //11.Select Department/Office
        Select departmentOffice = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentOffice.selectByIndex(faker.number().numberBetween(1,9));

        //12.Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(faker.number().numberBetween(1,8));

        //13.Select programming language from checkboxes
        WebElement programmingLanguage = Driver.getDriver().findElement(By.xpath("(//div//input[@class='form-check-input'])[1]"));
        programmingLanguage.click();

        //14.Click to sign up button
        WebElement signUpBtn = Driver.getDriver().findElement(By.xpath(""));
        //15.Verify success message “You’ve successfully completed registration.” is
        //displayed.
        //Note:
        //1. Use new Driver utility class and method
        //2. User JavaFaker when possible
        //3. User ConfigurationReader when it makes sense
    }
}


package com.cydeo.tests.day12pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractices {

    @Test
    public void required_field_error_message_test(){
        //TC #1: Required field error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com/
        Driver.getDriver().get("https://library1.cydeo.com/");

        //3- Do not enter any information
        //4- Click to “Sign in” button
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
    }

    @Test
    public void invalid_email_error_message_test(){
        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        //3- Enter invalid email format
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("hjgasef");
        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
    }

    @Test
    public void library_negative_login_test(){
        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        //3- Enter incorrect username or incorrect password
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        Faker faker = new Faker();
        libraryLoginPage.inputUsername.sendKeys(faker.internet().emailAddress());
        libraryLoginPage.inputPassword.sendKeys(faker.internet().password());
        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
    }
}
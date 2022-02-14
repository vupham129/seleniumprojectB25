package com.cydeo.tests.practice_ShortVideos;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC6_adamTask {
    public static void main(String[] args) throws InterruptedException {
        //TC:6 As a user I should be able to see the password as
        //"*******"
        // //1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        // //3-click Login label
        WebElement loginBtn = driver.findElement(By.linkText("LOGIN"));
        loginBtn.click();

        // //4-enter username "User1"
        WebElement userNameBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameBox.sendKeys("User1");

        // //5-enter password "UserUser123"
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("UserUser123");

        // //6-verify the password is hidden
        Thread.sleep(3000);
        String expectedPassword = "*******";
        String actualPassword = passwordBox.getAttribute("placeholder");

        System.out.println("actualPassword = " + actualPassword);


    }
}

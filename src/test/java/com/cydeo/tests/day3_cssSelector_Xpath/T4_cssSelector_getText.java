package com.cydeo.tests.day3_cssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {
//        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
//        3- Verify “Reset password” button text is as expected:
//        Expected: Reset password
       // WebElement resetPWButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        WebElement resetPWButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
//                                                                    tagName[attributeName='attributeValue']
        String expectedButtonText = "Reset password";
      String actualButtonText = resetPWButton.getText();

        System.out.println("actualButtonText = " + actualButtonText);
        if(actualButtonText.equals(expectedButtonText)){
            System.out.println("Reset password button text verification passed");
        }else{
            System.out.println("Reset password button text verification failed");
        }

    }
}

package com.cydeo.tests.practice_ShortVideos;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GasMileageCalculatorTest {
    public WebDriver driver;
    //Task #: Gas Mileage Calculator Automation Test
    //1. Add a new class GasMileageCalculatorTest
    @BeforeMethod
    public void setup(){
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //2. Go to https://www.calculator.net
        driver.get(ConfigurationReader.getProperty("env3"));
    }

    @Test
    public void gasMileageCalculatorTest(){
        //3. Search for “gas mileage” using search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //4. Click on the “Gas Mileage Calculator” link
        WebElement gasMileageCalcualatorLink = driver.findElement(By.xpath("//div//a[.='Gas Mileage Calculator']"));
        gasMileageCalcualatorLink.click();

        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        Assert.assertEquals(driver.getTitle(), "Gas Mileage Calculator");
        //b. “Gas Mileage Calculator” label is displayed
        WebElement gasMileageCalculatorElm = driver.findElement(By.xpath("//div//h1"));
        Assert.assertTrue(gasMileageCalculatorElm.isDisplayed(), "Gas Mileage Calculator is not displayed after clicking");

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometerField = driver.findElement(By.xpath("//input[@id='uscodreading']"));
        currentOdometerField.clear();
        currentOdometerField.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer = driver.findElement(By.xpath("//input[@id='uspodreading']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAddedField = driver.findElement(By.xpath("//input[@id='usgasputin']"));
        gasAddedField.clear();
        gasAddedField.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPriceField = driver.findElement(By.xpath("//input[@id='usgasprice']"));
        gasPriceField.clear();
        gasPriceField.sendKeys("3.55");

        //10. Click on Calculate button
        WebElement calculatorButton = driver.findElement(By.xpath("(//input[@value='Calculate'])[1]"));
        calculatorButton.click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg"
        WebElement mpgValue = driver.findElement(By.xpath("//font//b"));
        String actualResult = mpgValue.getText();
        String expectedResult = "23.44 mpg";
        Assert.assertEquals(actualResult,expectedResult);

    }


}

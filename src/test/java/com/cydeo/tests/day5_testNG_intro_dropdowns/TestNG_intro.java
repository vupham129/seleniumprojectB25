package com.cydeo.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_intro {

    @Test (priority = 1)// is used to run in order
    public void test1(){
        System.out.println("Test 1 is running...");

        //assertEquals: compare 2 of the same things

        String actual = "apple";
        String expected ="apple";
        Assert.assertEquals(actual, expected);


    }

    @Test (priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");

        String actual = "apple";
        String expected ="apple";
        Assert.assertTrue(actual.equals(expected));



    }

    @BeforeClass
    public void setupMethod(){
        System.out.println("---> BeforeClass is running");
    }

    @AfterMethod
    public void tearDownClass(){
        System.out.println("---> AfterClass is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--> BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--> AfterMethod is running!");
    }





}

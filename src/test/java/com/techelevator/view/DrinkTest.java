package com.techelevator.view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

    Beverages testDrinks = new Beverages("Fizzies", 20.00, 1);

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    @Test
    public void test_Drinks_GetName(){

        //Arrange
        String expectedResult = "Fizzies";

        //Act
        String actualResult = testDrinks.getName();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Drinks_GetPrice(){

        //Arrange
        double expectedResult = 20.00;

        //Act
        double actualResult = testDrinks.getPrice();

        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.1);
    }

    @Test
    public void test_Drinks_GetQuantity(){

        //Arrange
        int expectedResult = 1;

        //Act
        int actualResult = testDrinks.getQuantity();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}

package com.techelevator.view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

    Candy testCandy = new Candy("Chewies", 10.00, 1);

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    @Test
    public void test_Candy_GetName(){

        //Arrange
        String expectedResult = "Chewies";

        //Act
        String actualResult = testCandy.getName();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Candy_GetPrice(){

        //Arrange
        double expectedResult = 10.00;

        //Act
        double actualResult = testCandy.getPrice();

        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.1);
    }

    @Test
    public void test_Candy_GetQuantity(){

        //Arrange
        int expectedResult = 1;

        //Act
        int actualResult = testCandy.getQuantity();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}

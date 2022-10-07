package com.techelevator.view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {


    Gum testGummies = new Gum("Gummies", 2.00, 1);

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    @Test
    public void test_Gum_GetName(){

        //Arrange
        String expectedResult = "Gummies";

        //Act
        String actualResult = testGummies.getName();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Gum_GetPrice(){

        //Arrange
        double expectedResult = 2.00;

        //Act
        double actualResult = testGummies.getPrice();

        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.1);
    }

    @Test
    public void test_Gum_GetQuantity(){

        //Arrange
        int expectedResult = 1;

        //Act
        int actualResult = testGummies.getQuantity();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}

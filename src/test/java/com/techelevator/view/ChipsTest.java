package com.techelevator.view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {

    Chips testChips = new Chips("CHAAPS", 5000.00, 1);

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    @Test
    public void test_Chips_GetName(){

        //Arrange
        String expectedResult = "CHAAPS";

        //Act
        String actualResult = testChips.getName();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}

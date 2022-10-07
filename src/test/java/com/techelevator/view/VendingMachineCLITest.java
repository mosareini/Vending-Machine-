package com.techelevator.view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.techelevator.VendingMachineCLI.calcChange;

public class VendingMachineCLITest {

    Chips chippies = new Chips("chippies", 5.00, 3);
    Gum gummies = new Gum("gummies", 5.00, 3);
    Beverages sippies = new Beverages("sippies", 5.00, 3);
    Candy chewies = new Candy("chewies", 5.00, 3);

    @Before
    public void setUp(){}

    @After
    public void tearDown(){}

    @Test
    public void test_Yum_Yum_Statement_Chips(){

        //Arrange
        String expectedResult = "Crunch Crunch, Yum!";

        //Act
        String actualResult = chippies.yumYumStatement();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Yum_Yum_Statement_Gum(){

        //Arrange
        String expectedResult = "Chew Chew, Yum!";

        //Act
        String actualResult = gummies.yumYumStatement();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Yum_Yum_Statement_Beverages(){

        //Arrange
        String expectedResult = "Glug Glug, Yum!";

        //Act
        String actualResult = sippies.yumYumStatement();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Yum_Yum_Statement_Candy(){

        //Arrange
        String expectedResult = "Munch Munch, Yum!";

        //Act
        String actualResult = chewies.yumYumStatement();

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Change_No_Quarters(){

        //Arrange
        int changeInCents = 20;
        int[] expectedResult = {0,2,0};

        //Act
        int[] actualResult = calcChange(changeInCents);

        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
    @Test
    public void test_Change_No_Dimes(){

        //Arrange
        int changeInCents = 30;
        int[] expectedResult = {1,0,1};

        //Act
        int[] actualResult = calcChange(changeInCents);

        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void test_Change_Only_Nickels(){

        //Arrange
        int changeInCents = 5;
        int[] expectedResult = {0,0,1};

        //Act
        int[] actualResult = calcChange(changeInCents);

        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}

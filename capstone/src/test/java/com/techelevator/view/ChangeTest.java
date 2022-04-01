package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ChangeTest {
    Change change = new Change();

    @Test
    public void testNoChange() {
        String changeAmount = "0.00";
        BigDecimal bigDecimal = new BigDecimal(changeAmount);
        int[] intArr = new int[4];
        int counter = 0;
        int[] expectedArr = new int[]{0, 0, 0, 0};
        Change.looseChange(bigDecimal);

        for(int num : Change.looseChange(bigDecimal).values()){
            intArr[counter] = num;
        }

        String message = "Array should equal" + Arrays.toString(expectedArr) + ", but is actually " + Arrays.toString(intArr);
        assertArrayEquals(message, expectedArr, intArr);
    }

    @Test
    public void test1DollarChange() {
        String changeAmount = "1.00";
        BigDecimal bigDecimal = new BigDecimal(changeAmount);
        int[] intArr = new int[4];
        int counter = 0;
        int[] expectedArr = new int[]{1, 0, 0, 0};

        Change.looseChange(bigDecimal);
        for(int num : Change.looseChange(bigDecimal).values()){
            intArr[counter] = num;
            counter++;
        }

        String message = "Array should equal"  + Arrays.toString(expectedArr) + ", but is actually " + Arrays.toString(intArr);
        assertArrayEquals(message, expectedArr, intArr);
    }

    @Test
    public void testPartialDollarChange() {
        String changeAmount = "18.95";
        BigDecimal bigDecimal = new BigDecimal(changeAmount);
        int[] intArr = new int[4];
        int counter = 0;
        int[] expectedArr = new int[]{18, 0, 2, 3};

        Change.looseChange(bigDecimal);
        for(int num : Change.looseChange(bigDecimal).values()){
            intArr[counter] = num;
            counter++;
        }

        String message = "Array should equal"  + Arrays.toString(expectedArr) + ", but is actually " + Arrays.toString(intArr);
        assertArrayEquals(message, expectedArr, intArr);
    }

    @Test
    public void testNickelChange() {
        String changeAmount = "0.05";
        BigDecimal bigDecimal = new BigDecimal(changeAmount);
        int[] intArr = new int[4];
        int counter = 0;
        int[] expectedArr = new int[]{0, 1, 0, 0};

        Change.looseChange(bigDecimal);
        for(int num : Change.looseChange(bigDecimal).values()){
            intArr[counter] = num;
            counter++;
        }

        String message = "Array should equal"  + Arrays.toString(expectedArr) + ", but is actually " + Arrays.toString(intArr);
        assertArrayEquals(message, expectedArr, intArr);
    }
}

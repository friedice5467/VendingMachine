package com.techelevator.fileIO;

import com.techelevator.items.Drink;
import com.techelevator.items.FoodItem;
import com.techelevator.items.Munchy;
import com.techelevator.items.Sandwich;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void testUpdateInventory(){
        FoodItem foodItem = new Drink("drink","4.00","D7");
        FoodItem sando = new Sandwich("sando","4.00","D8");
        FoodItem munchy = new Munchy("munchy","4.00","D9");
        Map<FoodItem, Integer> testMap = new HashMap<>();
        testMap.put(foodItem, 3);
        testMap.put(sando, 4);
        testMap.put(munchy, 5);
        int[] actual = new int[3];
        int[] expected = new int[]{2,4,5};
        int counter = 0;

        for(int num : Inventory.updateInventory(testMap,foodItem).values()){
            actual[counter] = num;
            counter++;
        }

        String message = "Array should equal " + Arrays.toString(expected) + ", but actually is " + Arrays.toString(actual);
        assertArrayEquals(message, expected, actual);

    }

    @Test
    public void testUpdateInventory_secondValue(){
        FoodItem foodItem = new Drink("drink","4.00","D7");
        FoodItem sando = new Sandwich("sando","4.00","D8");
        FoodItem munchy = new Munchy("munchy","4.00","D9");
        Map<FoodItem, Integer> testMap = new HashMap<>();
        testMap.put(foodItem, 3);
        testMap.put(sando, 4);
        testMap.put(munchy, 5);
        int[] actual = new int[3];
        int[] expected = new int[]{3,3,5};
        int counter = 0;

        for(int num : Inventory.updateInventory(testMap,sando).values()){
            actual[counter] = num;
            counter++;
        }

        String message = "Array should equal " + Arrays.toString(expected) + ", but actually is " + Arrays.toString(actual);
        assertArrayEquals(message, expected, actual);

    }

    @Test
    public void testUpdateInventory_thirdValue(){
        FoodItem foodItem = new Drink("drink","4.00","D7");
        FoodItem sando = new Sandwich("sando","4.00","D8");
        FoodItem munchy = new Munchy("munchy","4.00","D9");
        Map<FoodItem, Integer> testMap = new HashMap<>();
        testMap.put(foodItem, 3);
        testMap.put(sando, 4);
        testMap.put(munchy, 5);
        int[] actual = new int[3];
        int[] expected = new int[]{3,4,4};
        int counter = 0;

        for(int num : Inventory.updateInventory(testMap,munchy).values()){
            actual[counter] = num;
            counter++;
        }

        String message = "Array should equal " + Arrays.toString(expected) + ", but actually is " + Arrays.toString(actual);
        assertArrayEquals(message, expected, actual);

    }
}

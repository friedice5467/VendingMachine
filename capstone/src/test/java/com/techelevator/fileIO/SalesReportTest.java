package com.techelevator.fileIO;

import com.techelevator.items.Drink;
import com.techelevator.items.FoodItem;
import com.techelevator.items.Munchy;
import com.techelevator.items.Sandwich;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SalesReportTest {

    @Test
    public void testIfSalesReportIsCreated() {
        FoodItem foodItem = new Drink("drink","4.00","D7");
        FoodItem sando = new Sandwich("sando","4.00","D8");
        FoodItem munchy = new Munchy("munchy","4.00","D9");
        Map<FoodItem, Integer> testMap = new HashMap<>();
        testMap.put(foodItem, 3);
        testMap.put(sando, 4);
        testMap.put(munchy, 5);
        SalesReport.createSalesReport(testMap);
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM_dd_yyyy_hhmm_a");
        LocalDateTime now = LocalDateTime.now();
        String path = now.format(targetFormat) + "sales_report.csv";
        File file = new File(path);
        String message = "Expected function to create a file but file not found";


        assertTrue(message, file.exists());
    }
}

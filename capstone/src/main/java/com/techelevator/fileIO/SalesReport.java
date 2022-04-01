package com.techelevator.fileIO;

import com.techelevator.items.FoodItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalesReport {
    private static int startingInventoryAmount = 7;

    public static int getStartingInventoryAmount() {
        return startingInventoryAmount;
    }

    public static void createSalesReport(Map<FoodItem, Integer> productMap){
        DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM_dd_yyyy_hhmm_a");
        LocalDateTime now = LocalDateTime.now();
        String path = now.format(targetFormat) + "sales_report.csv";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            BigDecimal sum = new BigDecimal("0.00");
            for(FoodItem foodItem : productMap.keySet()){
                int itemsSold = startingInventoryAmount - productMap.get(foodItem);
                sum = sum.add((foodItem.getPrice().multiply(new BigDecimal(itemsSold))));
                writer.println(foodItem.getName() + "," + itemsSold);
            }
            writer.println();
            writer.println("Total Sales: $" + sum);
        }
        catch (IOException e){}
    }
}

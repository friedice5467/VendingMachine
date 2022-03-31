package com.techelevator.ui;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InventoryGrabber {

    public static List grabInventory() throws FileNotFoundException {
        String inventoryName = "catering.csv";
        String inventoryName1 = "catering1.csv";
        File file = new File(inventoryName);
        List<FoodItem> inventory = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split("\\,");

                String slot = columns[0].trim();
                String name = columns[1].trim();
                String itemType = columns[2].trim();
                String price = columns[3].trim();

                FoodItem foodItem;

                switch (itemType) {
                    case "Dessert":
                        foodItem = new Dessert(name, price, slot, itemType);
                        break;
                    case "Munchy":
                        foodItem = new Munchy(name, price, slot, itemType);
                        break;
                    case "Sandwich":
                        foodItem = new Sandwich(name, price, slot, itemType);
                        break;
                    case "Drink":
                    default:
                        foodItem = new Drink(name, price, slot, itemType);
                        break;
                }
                inventory.add(foodItem);
            }





            return inventory;

        }
    }


}

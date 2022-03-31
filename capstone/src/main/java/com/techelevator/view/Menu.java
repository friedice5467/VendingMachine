package com.techelevator.view;

import com.techelevator.items.FoodItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static BigDecimal currentMoney = new BigDecimal("0.00");


    private static final Scanner input = new Scanner(System.in);

    public static String getHomeScreenChoice(){

        System.out.println();
        System.out.println("D) Display CaTEring Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");
        System.out.println();

        return input.nextLine().trim().toLowerCase();


    }

    public static BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public static String getPurchaseChoice(){
            // purchase an item
            System.out.println("(M) Feed Money");
            //do stuff at m
            System.out.println("(S) Select Item");
            // do stuff at s
            System.out.println("(F) Finish Transaction");
            // do stuff at f
            System.out.println( "$" + getCurrentMoney());
            // do stuff normal

        return input.nextLine().trim().toLowerCase();

    }

    public static void acceptMoney(){
        System.out.println("Enter bills >>> ");
        BigDecimal enteredMoney = new BigDecimal(input.nextLine());
        currentMoney = currentMoney.add(enteredMoney);
        System.out.println("$" + currentMoney);
    }

    public static void selectItem(List<FoodItem> productList, Map<FoodItem, Integer> productMapAmount) {
        for (FoodItem foodItem : productList) {
            System.out.print(foodItem.getSlot() + ") " + foodItem.getName() + " " + foodItem.getPrice());
            if (productMapAmount.get(foodItem) == 0) {
                System.out.println(" NO LONGER AVAILABLE");
            } else {
                System.out.println();
            }
        }
        System.out.print("Please make a selection: ");
        String selection = input.nextLine();
        for (FoodItem foodItem : productList){
            String slot = foodItem.getSlot();
            if(selection.equals(slot)){
                System.out.println("test");
                if (productMapAmount.get(foodItem) == 0){
                    System.out.println("This item is no longer available");
                    return;
                } else if (productMapAmount.get(foodItem) > 0) {
                    // Select this item
                    System.out.println(foodItem.getName() + " " + foodItem.getPrice());
                    System.out.println("Money remaining: " + getCurrentMoney());
                    switch (foodItem.getItemType()){
                        case "Sandwich":
                            System.out.println("Sandwich So Delicious, Yum!");
                            break;
                        case "Munchy":
                            System.out.println("Munchy, Munchy, so Good!");
                            break;
                        case "Dessert":
                            System.out.println("Sugar, Sugar, so Sweet!");
                            break;
                        case "Drink":
                            System.out.println("Drinky, Drinky, Slurp Slurp!");
                            break;
                    }

                    productMapAmount.put(foodItem, productMapAmount.get(foodItem)-1);
                }
            }
        }
        System.out.println("Item does not exist");
    }
}

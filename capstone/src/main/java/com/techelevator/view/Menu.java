package com.techelevator.view;

import com.techelevator.items.FoodItem;
import com.techelevator.fileIO.Audit;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static BigDecimal currentMoney = new BigDecimal("0.00");
    private static BigDecimal previousMoney = new BigDecimal("0.00");
    private static BigDecimal enteredMoney = new BigDecimal("0.00");


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

    public static void displayItems(List<FoodItem> productList, Map<FoodItem, Integer> productMapAmount) {
        for(FoodItem foodItem : productList){
            System.out.print(foodItem.getSlot() + ") " + foodItem.getName() + " $" + foodItem.getPrice());
            if (productMapAmount.get(foodItem) == 0) {
                System.out.println(" NO LONGER AVAILABLE");
            } else {
                System.out.println();
            }
        }
    }

    public static String getPurchaseChoice(){
            // purchase an item
            System.out.println("(M) Feed Money");
            //do stuff at m
            System.out.println("(S) Select Item");
            // do stuff at s
            System.out.println("(F) Finish Transaction");
            // do stuff at f
            System.out.println( "$" + getCurrentMoney() + "\n");
            // do stuff normal

        return input.nextLine().trim().toLowerCase();

    }

    public static void acceptMoney(){
        System.out.println("A) $1");
        System.out.println("B) $5");
        System.out.println("C) $10");
        System.out.println("D) $20");
        System.out.print("Enter selection >>> ");
        try {
            String moneySelection = input.nextLine();

            if (moneySelection.equalsIgnoreCase("a")) {
                enteredMoney = new BigDecimal("1.00");
            } else if (moneySelection.equalsIgnoreCase("b")) {
                enteredMoney = new BigDecimal("5.00");
            } else if (moneySelection.equalsIgnoreCase("c")) {
                enteredMoney = new BigDecimal("10.00");
            } else if (moneySelection.equalsIgnoreCase("d")) {
                enteredMoney = new BigDecimal("20.00");
            } else {
                System.out.println("Invalid bill denomination\n");
            }

            previousMoney = currentMoney;
            currentMoney = currentMoney.add(enteredMoney);
            System.out.println("$" + currentMoney + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid bill denomination\n");
        }

    }

    public static void subtractMoney(BigDecimal price){
        previousMoney = currentMoney;
        currentMoney = currentMoney.subtract(price);
    }

    public static BigDecimal getPreviousMoney() {
        return previousMoney;
    }

    public static BigDecimal getEnteredMoney() {
        return enteredMoney;
    }

    public static void selectItem(List<FoodItem> productList, Map<FoodItem, Integer> productMapAmount) {
        for (FoodItem foodItem : productList) {
            System.out.print(foodItem.getSlot() + ") " + foodItem.getName() + " $" + foodItem.getPrice());
            if (productMapAmount.get(foodItem) == 0) {
                System.out.println(" NO LONGER AVAILABLE");
            } else {
                System.out.println();
            }
        }
        System.out.print("Please make a selection: ");
        String selection = input.nextLine().toUpperCase();
        int counter = 0;
        for (FoodItem foodItem : productList){
            String slot = foodItem.getSlot();
            if(selection.equals(slot)){
                counter++;
                if (productMapAmount.get(foodItem) == 0){
                    System.out.println("This item is no longer available\n");
                    return;
                } else if (productMapAmount.get(foodItem) > 0) {
                    // Select this item
                    if(getCurrentMoney().compareTo(foodItem.getPrice()) >= 0) {
                        System.out.println(foodItem.getName() + " $" + foodItem.getPrice());
                        subtractMoney(foodItem.getPrice());
                        System.out.println("Money remaining: $" + getCurrentMoney());
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
                        System.out.println();
                        productMapAmount.put(foodItem, productMapAmount.get(foodItem)-1);
                    }
                    else{
                        System.out.println("Funds low, deposit more money.\n");
                    }
                }
                Audit.createAuditFile(foodItem);
            }
        }
        if(counter <= 0) System.out.println("Item does not exist\n");
    }

    public static void finishPurchases(){
        Map<String, Integer> changeMap =  Change.looseChange(currentMoney);
        System.out.println("Dollars: " + changeMap.get("Dollars") + " ");
        System.out.println("Quarters: " + changeMap.get("Quarters") + " ");
        System.out.println("Dimes: " + changeMap.get("Dimes") + " ");
        System.out.println("Nickels: " + changeMap.get("Nickels") + " ");
        subtractMoney(currentMoney);
        System.out.println("Current money: $" + getCurrentMoney());
    }
}

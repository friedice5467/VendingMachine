package com.techelevator.view;

import java.math.BigDecimal;
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

    public static void selectItem(){

    }


}

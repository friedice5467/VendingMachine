package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

    private static final Scanner input = new Scanner(System.in);

    public static String getHomeScreenChoice(){

        System.out.println();
        System.out.println("D) Display CaTEring Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");
        System.out.println();

        return input.nextLine().trim().toLowerCase();


    }


}

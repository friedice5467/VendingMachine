package com.techelevator.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInput {

    public static void grabInventory() throws FileNotFoundException {
        String inventoryName = "C:\\Users\\Student\\workspace\\module-1-capstone-team-5\\capstone\\catering.csv";
        File file = new File(inventoryName);
        String inventoryName1 = "C:\\Users\\Student\\workspace\\module-1-capstone-team-5\\capstone\\catering1.csv";

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();;
                //do stuff
            }


        }
    }


}

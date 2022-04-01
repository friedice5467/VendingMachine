package com.techelevator.fileIO;

import com.techelevator.items.FoodItem;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Audit {

    public static void createAuditFile(String purchaseChoice)
    {
        String path = "audit.txt";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            LocalDateTime now = LocalDateTime.now();

            String currentTime = now.format(targetFormat);
            if(purchaseChoice.equals("m"))writer.println(currentTime + " MONEY FED:       $" + Menu.getEnteredMoney() + " $" + Menu.getCurrentMoney());
            else if(purchaseChoice.equals("f"))writer.println(currentTime +  " CHANGE GIVEN:    $" + Menu.getPreviousMoney() + " $" + Menu.getCurrentMoney());



        }
        catch (IOException e)
        {

        }
    }

    public static void createAuditFile(FoodItem foodItem)
    {
        String path = "audit.txt";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            LocalDateTime now = LocalDateTime.now();

            String currentTime = now.format(targetFormat);
            writer.println(currentTime + " " + foodItem.getName() + "  " + foodItem.getSlot() +"      $" +Menu.getPreviousMoney() + " $" + Menu.getCurrentMoney());
            
        }
        catch (IOException e)
        {

        }
    }

}

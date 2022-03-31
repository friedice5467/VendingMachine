package com.techelevator.view;

import java.math.BigDecimal;
import java.util.HashMap;

public class Change {


    public static HashMap<String, Integer> looseChange(int cent) {
        int pennyCount = 0;
        int nickelCount = 0;
        int dimeCount = 0;
        int quarterCount = 0;

        if(cent > 0) {
            quarterCount = cent/25;
            dimeCount = (cent%25)/10;
            nickelCount = ((cent%25)%10)/5;
            pennyCount = ((cent%25)%10)%5;
        }else{
            pennyCount = 0;
            dimeCount = 0;
            nickelCount = 0;
            quarterCount = 0;
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", pennyCount);
        map.put("Nickels", nickelCount);
        map.put("Dimes", dimeCount);
        map.put("Quarters", quarterCount);

        return map;
    }
}

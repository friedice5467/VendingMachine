package com.techelevator.view;

import java.math.BigDecimal;
import java.util.HashMap;

public class Change {


    public static HashMap<String, Integer> looseChange(BigDecimal change) {

        BigDecimal hundred = new BigDecimal("100.0");
        int cent = change.multiply(hundred).intValue();

        int dollarCount = 0;
        int nickelCount = 0;
        int dimeCount = 0;
        int quarterCount = 0;

        if (cent > 0) {
            dollarCount = cent / 100;
            quarterCount = (cent % 100) / 25;
            dimeCount = (cent % 25) / 10;
            nickelCount = ((cent % 25) % 10) / 5;

        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Dollars", dollarCount);
        map.put("Nickels", nickelCount);
        map.put("Dimes", dimeCount);
        map.put("Quarters", quarterCount);

        return map;
    }
}

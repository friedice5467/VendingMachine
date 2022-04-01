package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void testAddMoneyBy1() {
        Money.setCurrentMoney(new BigDecimal("0.00"));
        String moneySelection = "a";
        BigDecimal expectedMoney = new BigDecimal("1.00");
        String actual = Money.updateMoney(moneySelection);
        String expected = "$" + expectedMoney;
        String message = "Expected string is " + expected + " but was actually " + actual;

        assertEquals(message, expected, actual);
    }

    @Test
    public void testAddMoneyBy5() {
        Money.setCurrentMoney(new BigDecimal("0.00"));
        String moneySelection = "b";
        BigDecimal expectedMoney = new BigDecimal("5.00");
        String actual = Money.updateMoney(moneySelection);
        String expected = "$" + expectedMoney;
        String message = "Expected string is " + expected + " but was actually " + actual;

        assertEquals(message, expected, actual);
    }

    @Test
    public void testAddMoneyBy10() {
        Money.setCurrentMoney(new BigDecimal("0.00"));
        String moneySelection = "c";
        BigDecimal expectedMoney = new BigDecimal("10.00");
        String actual = Money.updateMoney(moneySelection);
        String expected = "$" + expectedMoney;
        String message = "Expected string is " + expected + " but was actually " + actual;

        assertEquals(message, expected, actual);
    }

    @Test
    public void testAddMoneyBy20() {
        Money.setCurrentMoney(new BigDecimal("0.00"));
        String moneySelection = "d";
        BigDecimal expectedMoney = new BigDecimal("20.00");
        String actual = Money.updateMoney(moneySelection);
        String expected = "$" + expectedMoney;
        String message = "Expected string is " + expected + " but was actually " + actual;

        assertEquals(message, expected, actual);
    }
}

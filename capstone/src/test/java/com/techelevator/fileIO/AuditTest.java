package com.techelevator.fileIO;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AuditTest {


    @Test
    public void testIfCreatedAuditFileForM() {
        String purchaseChoice = "m";
        Audit.createAuditFile(purchaseChoice);
        String fileName = "audit.txt";
        File outFile = new File(fileName);
        String message = "Expected function to create a file but file not found";

        assertTrue(message, outFile.exists());
    }

    @Test
    public void testIfCreatedAuditFileForF() {
        String purchaseChoice = "f";
        Audit.createAuditFile(purchaseChoice);
        String fileName = "audit.txt";
        File outFile = new File(fileName);
        String message = "Expected function to create a file but file not found";

        assertTrue(message, outFile.exists());
    }

}

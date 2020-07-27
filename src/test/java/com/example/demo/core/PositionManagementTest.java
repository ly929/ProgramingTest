package com.example.demo.core;

import com.example.demo.core.entity.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** 
* PositionManagement Tester. 
* 
* @version 1.0
*/ 

public class PositionManagementTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /**
    * 
    * Method: handleInput(List<Transaction> transactionList) 
    * 
    */ 
    @Test
    public void testHandleInput() throws Exception {
        System.out.println("PositionManagementTest start...");
        List<Transaction> transactionList1 = new ArrayList<>();
        transactionList1.add(new Transaction("REL", 50, "INSERT", "Buy"));
        transactionList1.add(new Transaction("ITC", 40, "INSERT", "Sell"));
        transactionList1.add(new Transaction("INF", 70, "INSERT", "Buy"));
        transactionList1.add(new Transaction("REL", 60, "UPDATE", "Buy"));
        transactionList1.add(new Transaction("ITC", 30, "CANCEL", "Buy"));
        transactionList1.add(new Transaction("INF", 20, "INSERT", "Sell"));
        new PositionManagement().handleInput(transactionList1);


        List<Transaction> transactionList2 = new ArrayList<>();
        for (int i = 0;i<10000; i++) {
            transactionList2.add(new Transaction("REL", i, "INSERT", "Sell"));
            transactionList2.add(new Transaction("REL", i+1, "INSERT", "Buy"));
            transactionList2.add(new Transaction("INF", i, "INSERT", "Buy"));
            transactionList2.add(new Transaction("INF", i+1, "INSERT", "Sell"));
        }
//        transactionList2.add(new Transaction(1L, 1L, 1L, "INF", 1, "CANCEL", "Sell"));
//        transactionList2.add(new Transaction(1L, 1L, 1L, "ITC", 1, "INSERT", "Sell"));
//        transactionList2.add(new Transaction(1L, 1L, 1L, "ITC", 10, "UPDATE", "Sell"));
        new PositionManagement().handleInput(transactionList2);


        System.out.println("PositionManagementTest end...");
    } 

    
}

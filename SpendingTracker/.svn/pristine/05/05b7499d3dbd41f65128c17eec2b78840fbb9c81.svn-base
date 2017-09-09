package com.example.jinlin.spendingtracker;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Jinlin on 5/2/17.
 */

public class JsonTest {
    String json = "{\n" +
        "\"item\": \"movie ticket\", \n" +
        "\"amount\": 4.5, \n" +
        "\"location\": \"theater\", \n" +
        "\"date\": \"May 3\", \n" +
        "\"imagePath\": \"User/Jinlin/Downloads/receipt.jpg\"\n" + "}";


    Gson gson = new Gson();
    Expense expense;

    @Before
    public void initializeExpense(){
        expense = gson.fromJson(json, Expense.class);
    }

    @Test
    public void jsonItemTest() throws Exception{
        assertEquals("movie ticket", expense.getItem());
    }

    @Test
    public void jsonAmountTest() throws Exception{
        assertEquals(4.5, expense.getAmount(), 0.0);

    }

    @Test
    public void jsonLocationTest() throws Exception{
        assertEquals("theater", expense.getLocation());
    }

    @Test
    public void jsonDateTest() throws Exception{
        assertEquals("May 3", expense.getDate());
    }

    @Test
    public void jsonImagePathTest() throws Exception{
        assertEquals("User/Jinlin/Downloads/receipt.jpg", expense.getImagePath());
    }
}

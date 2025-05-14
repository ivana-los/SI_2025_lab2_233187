package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryStatement() {
        // allitems=null
        Exception ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "986354321000"));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        //name=null
        Item unnamed = new Item(null, 2, 200, 0.1);
        Exception ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Collections.singletonList(unnamed), "1234555566667700"));
        assertEquals("Invalid item!", ex2.getMessage());

        //sodrzi bukvi
        Item normalItem = new Item("Sunset", 1, 50, 0);
        Exception ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(normalItem), "1234abad2378lele"));
        assertEquals("Invalid character in card number!", ex3.getMessage());

        // card.length!=16
        Exception ex4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(normalItem), "12"));
        assertEquals("Invalid card number!", ex4.getMessage());


        Item Flower = new Item("Bear", 15, 380, 0.20);
        double total = SILab2.checkCart(Arrays.asList(Flower), "8182377766665544");
        assertEquals(4530.0, total, 0.01);
    }
    @Test
    void testMultipleCondition() {
        // Price > 300
        Item premiumItem = new Item("Cat", 1, 350, 0.0);
        SILab2.checkCart(Arrays.asList(premiumItem), "1234030012236372");

        // Discount > 0
        Item promoItem = new Item("Dog", 4, 20, 0.10);
        SILab2.checkCart(Arrays.asList(promoItem), "4474655516662737");

        // Quantity > 10
        Item bulkOrder = new Item("Giraffe", 16, 90, 0.0);
        SILab2.checkCart(Arrays.asList(bulkOrder), "8888999900001111");


        Item regularItem = new Item("Zebra", 1, 60, 0.0);
        SILab2.checkCart(Arrays.asList(regularItem), "1993884877568900");
    }
}
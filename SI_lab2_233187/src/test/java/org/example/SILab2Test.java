package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryStatement() {
        // 1. allItems = null
        RuntimeException e1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345091")
        );
        assertEquals("allItems list can't be null!", e1.getMessage());

        // 2. item.getName() == null
        Item itemWithNullName = new Item(null, 3, 50, 0.0);
        RuntimeException e2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(itemWithNullName), "1234567812345678")
        );
        assertEquals("Invalid item!", e2.getMessage());

        // 3. invalid cardnumber (sodrzi bukvi)
        Item validItem = new Item("Moon", 1, 100, 0.0);
        RuntimeException e3 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(validItem), "1234abcde234ggh")
        );
        assertEquals("Invalid character in card number!", e3.getMessage());

        // 4. cardNumber (dolzina !=16)
        RuntimeException e4 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(validItem), "1234")
        );
        assertEquals("Invalid card number!", e4.getMessage());

        // 5. celosno testiranje
        Item bread = new Item("Salad", 11, 301, 0.2);
        double result = SILab2.checkCart(List.of(bread), "1111226233234455");
        assertEquals(530.0, result, 0.01);
    }
    @Test
    void testMultipleCondition() {
        // price > 300
        Item item1 = new Item("A", 1, 301, 0);
        SILab2.checkCart(List.of(item1), "1234567890123456");

        // discount > 0
        Item item2 = new Item("B", 1, 50, 0.1);
        SILab2.checkCart(List.of(item2), "1234567890123456");

        // quantity > 10
        Item item3 = new Item("C", 11, 100, 0);
        SILab2.checkCart(List.of(item3), "1234567890123434");


        Item item4 = new Item("D", 1, 100, 0);
        SILab2.checkCart(List.of(item4), "1234567890123456");
    }
}
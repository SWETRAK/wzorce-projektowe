package com.example.models.cart;

import com.example.models.cart.memento.CartMemento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

// Tydzień 12, Testy jednostkowe, Maciej Potręć
// Klasa testowa dla ShoppingCart, która sprawdza różne funkcjonalności koszyka zakupowego
class ShoppingCartTest {
    private ShoppingCart cart;
    private CartItem item1;
    private CartItem item2;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        item1 = new ProductCartItem("Test Book 1", 19.99, 1);
        item2 = new ProductCartItem("Test Book 2", 29.99, 2);
    }

    @Test
    void testAddAndRemoveItems() {
        assertEquals(0.0, cart.getPrice());

        cart.addItem(item1);
        assertEquals(19.99, cart.getPrice());

        cart.addItem(item2);
        assertEquals(79.97, cart.getPrice());

        cart.removeItem(item1);
        assertEquals(59.98, cart.getPrice());
    }

    @Test
    void testPriceCalculationAndRounding() {
        CartItem item3 = new ProductCartItem("Test Book 3", 10.995, 1);
        CartItem item4 = new ProductCartItem("Test Book 4", 5.666, 1);

        cart.addItem(item3);
        cart.addItem(item4);

        assertEquals(16.67, cart.getPrice());
    }

    @Test
    void testIteratorFunctionality() {
        cart.addItem(item1);
        cart.addItem(item2);

        // Test forward iteration
        assertTrue(cart.hasNext());
        assertEquals(item1, cart.next());

        assertTrue(cart.hasNext());
        assertEquals(item2, cart.next());

        assertFalse(cart.hasNext());

        // Test backward iteration
        assertTrue(cart.hasPrevious());
        assertEquals(item2, cart.getPrevious());

        assertTrue(cart.hasPrevious());
        assertEquals(item1, cart.getPrevious());

        assertFalse(cart.hasPrevious());
    }

    @Test
    void testMementoPatternSaveAndRestore() {
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals(79.97, cart.getPrice());

        CartMemento memento = cart.save();

        cart.removeItem(item1);
        assertEquals(59.98, cart.getPrice());

        cart.restore(memento);

        assertEquals(79.97, cart.getPrice());
    }

    @Test
    void testDisplayMethod() {
        cart.addItem(item1);
        cart.addItem(item2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            cart.display();
            String output = outputStream.toString();

            assertTrue(output.contains("Shopping Cart Contents:"));
            assertTrue(output.contains("Total: $79.97"));
        } finally {
            System.setOut(originalOut);
        }
    }
}
// Koniec, Tydzień 12, Testy jednostkowe, Maciej Potręć
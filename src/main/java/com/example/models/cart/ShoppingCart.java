package com.example.models.cart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

// Tydzień 3, Wzorzec Composite, Maciej Potręć
// Kompozyt - koszyk zakupowy zawierający wiele elementów
public class ShoppingCart implements CartItem {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double sum = items.stream().mapToDouble(CartItem::getPrice).sum();
        return Math.round(sum * 100.0) / 100.0;
    }

    @Override
    public void display() {
        System.out.println("Shopping Cart Contents:");
        items.forEach(CartItem::display);
        System.out.println("Total: $" + getPrice());
    }
}
// Koniec, Tydzień 3, Wzorzec Composite, Maciej Potręć

package com.example.models.cart.memento;

import com.example.models.cart.CartItem;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Memento, Maciej Potręć
// Klasa CartMemento przechowuje stan koszyka zakupowego
public class CartMemento {
    private final List<CartItem> items;

    public CartMemento(List<CartItem> items) {
        this.items = new ArrayList<>(items);
    }

    public List<CartItem> getSavedItems() {
        return items;
    }
}
// Koniec, Tydzień 6, Wzorzec Memento, Maciej Potręć

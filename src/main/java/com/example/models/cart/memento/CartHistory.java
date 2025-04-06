package com.example.models.cart.memento;

import com.example.models.cart.ShoppingCart;

import java.util.Stack;

// Tydzień 6, Wzorzec Memento, Maciej Potręć
// Klasa CartHistory przechowuje historię zmian koszyka zakupowego
public class CartHistory {
    private final Stack<CartMemento> history = new Stack<>();
    private final ShoppingCart cart;

    public CartHistory(ShoppingCart cart) {
        this.cart = cart;
        saveState();
    }

    public void saveState() {
        history.push(cart.save());
        System.out.println("Cart state saved");
    }

    public void undo() {
        if (history.size() <= 1) {
            System.out.println("No more changes to undo");
            return;
        }

        history.pop();

        cart.restore(history.peek());
        System.out.println("Undo successful - cart restored to previous state");
    }

    public void clearHistory() {
        CartMemento currentState = history.peek();
        history.clear();
        history.push(currentState);
    }

    public int getHistorySize() {
        return history.size();
    }
}
// Koniec, Tydzień 6, Wzorzec Memento, Maciej Potręć

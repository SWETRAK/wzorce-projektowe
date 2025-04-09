package com.example.services.order.stock;

import com.example.models.cart.ProductCartItem;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Observer, Kamil Pietrak
// Klasa zarządzająca stanem magazynowym i powiadamiająca obserwatorów
public class StockSystem {

    private final List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void updateStock(ProductCartItem item) {
        System.out.println("Updating stock for: " + item.getProduct().toString() + " -> " + item.getQuantity() + " -> " + item.getPrice());
        notifyObservers(item);
    }

    private void notifyObservers(ProductCartItem item) {
        for (StockObserver o : observers) {
            o.update(item);
        }
    }
}
// Koniec, Tydzień 6, Wzorzec Observer, Kamil Pietrak
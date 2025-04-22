package com.example.services.books;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Tydzień 7, Zasada SRP, Kamil Pietrak
// Klasa zarządzająca dostępem do danych o stanie magazynu
public class WarehouseBookRepository {

    private static final Map<String, Integer> stocks = new HashMap<>();

    public void saveStock(String productId, int quantity) {
        stocks.put(productId, quantity);
        System.out.println("Stock updated for " + productId + ": " + quantity);
    }

    public int getStock(String productId) {
        Integer stock = stocks.get(productId);
        if (stock == null) {
            int randomNumber = new Random().nextInt(100);
            stocks.put(productId, randomNumber);
            return randomNumber;
        }
        return stock;
    }

    public String searchBook(String title) {
        return "Book found in warehouse: " + title;
    }
}
// Koniec, Tydzień 7, Zasada SRP, Kamil Pietrak
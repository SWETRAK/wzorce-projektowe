package com.example.services.books;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Tydzień 7, Zasada SRP, Kamil Pietrak
// Klasa zarządzająca dostępem do danych o stanie magazynu
// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// WarehouseBookRepository - konkretna implementacja repozytorium książek w pamięci.
public class WarehouseBookRepository extends AbstractRepository  {

    private static final int DEFAULT_EMPTY_STOCK = 0;
    private static final int DEFAULT_MAX_FULL_STOCK = 100;

    private static final Map<String, Integer> stocks = new HashMap<>();

    public void saveStock(String productId, int quantity) {
        stocks.put(productId, quantity);
        System.out.println("Stock updated for " + productId + ": " + quantity);
    }

    public int getStock(String productId) {
        Integer stock = stocks.get(productId);
        if (stock == null) {
            int randomNumber = new Random().nextInt(DEFAULT_MAX_FULL_STOCK);
            stocks.put(productId, randomNumber);
            return randomNumber;
        }
        return stock;
    }

    @Override
    public void save(String book, Integer quantity) {
        stocks.put(book, quantity);
    }

    @Override
    public Integer findStock(String title) {
         return stocks.getOrDefault(title, DEFAULT_EMPTY_STOCK);
    }

    @Override
    public String searchBook(String title) {
        return "Book found in warehouse: " + title;
    }
}
// Koniec, Tydzień 7, Zasada SRP, Kamil Pietrak
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
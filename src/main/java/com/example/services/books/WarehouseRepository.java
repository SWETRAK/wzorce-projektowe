package com.example.services.books;

// Tydzień 7, Zasada SRP, Kamil Pietrak
// Klasa zarządzająca dostępem do danych o stanie magazynu
public class WarehouseRepository {

    public void saveStock(String productId, int quantity) {
        System.out.println("Stock updated for " + productId + ": " + quantity);
    }

    public int getStock(String productId) {
        return 10;
    }

    public String searchBook(String title) {
        return "Book found in warehouse: " + title;
    }
}
// Koniec, Tydzień 7, Zasada SRP, Kamil Pietrak
package com.example.services.purchase;

import java.util.ArrayList;
import java.util.List;

//Tydzień 5, Wzorzec Iterator, Joanna Kozar
// Implementacja kolekcji historii zakupów

public class PurchaseHistory {
    private final List<String> purchases = new ArrayList<>();

    public void addPurchase(String bookTitle) {
        purchases.add(bookTitle);
    }

    public PurchaseIterator getIterator() {
        return new PurchaseHistoryIterator(purchases);
    }
}
//Koniec - Tydzień 5, Wzorzec Iterator, Joanna Kozar
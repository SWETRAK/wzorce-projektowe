package com.example.services.purchase;

import java.util.List;

//Tydzień 5, Wzorzec Iterator, Joanna Kozar
// Implementacja iteratora historii zakupów użytkownika
public class PurchaseHistoryIterator implements PurchaseIterator {
    private final List<String> purchases;
    private int index = 0;

    public PurchaseHistoryIterator(List<String> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean hasNext() {
        return index < purchases.size();
    }

    @Override
    public String next() {
        return hasNext() ? purchases.get(index++) : null;
    }
}
//Koniec - Tydzień 5, Wzorzec Iterator, Joanna Kozar
package com.example.models.discount;

// Tydzień 3, Wzorzec Composite, Kamil Pietrak
// Interfejs reprezentujący zniżkę
public interface PriceDiscount {

    void applyDiscount(double price);

    double getSalePrice();
}
// Koniec, Tydzień 3, Wzorzec Composite, Kamil Pietrak
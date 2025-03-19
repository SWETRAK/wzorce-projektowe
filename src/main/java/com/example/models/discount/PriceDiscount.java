package com.example.models.discount;

// Tydzień 2, Wzorzec Composite, Kamil Pietrak
// Interfejs reprezentujący zniżkę
public interface PriceDiscount {

    void applyDiscount(double price);

    double getSalePrice();
}
// Konic, Tydzień 2, Wzorzec Composite, Kamil Pietrak
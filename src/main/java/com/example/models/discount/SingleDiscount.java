package com.example.models.discount;

// Tydzień 3, Wzorzec Composite, Kamil Pietrak
// Klasa implementująca pojedynczą zniżkę
public class SingleDiscount implements PriceDiscount {

    private double salePrice;

    private final double discount;

    public SingleDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public void applyDiscount(double price) {
        salePrice = price * discount;
    }

    @Override
    public double getSalePrice() {
        return salePrice;
    }
}
// Koniec, Tydzień 3, Wzorzec Composite, Kamil Pietrak

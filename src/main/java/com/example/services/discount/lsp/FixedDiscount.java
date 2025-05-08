package com.example.services.discount.lsp;

import com.example.models.discount.PriceDiscount;

// Tydzień 8, Zasada Podstawienia Liskov, Maciej Potręć
// Klasa FixedDiscount implementująca interfejs PriceDiscount
public class FixedDiscount implements PriceDiscount {
    private double fixedAmount;
    private double priceAfterDiscount;

    public FixedDiscount(double fixedAmount) {
        if (fixedAmount < 0) {
            throw new IllegalArgumentException("Fixed discount amount cannot be negative.");
        }
        this.fixedAmount = fixedAmount;
    }

    @Override
    public void applyDiscount(double price) {
        this.priceAfterDiscount = Math.max(0, price - fixedAmount);
    }

    @Override
    public double getSalePrice() {
        return priceAfterDiscount;
    }
}
// Koniec, Tydzień 8, Zasada Podstawienia Liskov, Maciej Potręć

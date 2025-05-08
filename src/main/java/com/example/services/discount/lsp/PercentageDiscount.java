package com.example.services.discount.lsp;

import com.example.models.discount.PriceDiscount;

// Tydzień 8, Zasada Podstawienia Liskov, Maciej Potręć
// Klasa FixedDiscount implementująca interfejs PriceDiscount
public class PercentageDiscount implements PriceDiscount {
    private double percentage;
    private double priceAfterDiscount;

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("Percentage must be between 0 and 1.");
        }
        this.percentage = percentage;
    }

    @Override
    public void applyDiscount(double price) {
        this.priceAfterDiscount = price * (1 - percentage);
    }

    @Override
    public double getSalePrice() {
        return priceAfterDiscount;
    }
}
// Koniec, Tydzień 8, Zasada Podstawienia Liskov, Maciej Potręć

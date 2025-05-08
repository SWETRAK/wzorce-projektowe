package com.example.services.discount.dip;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// DiscountStrategy jako interfejs wysokiego poziomu dla renderowania faktur
public interface DiscountStrategy {
    double applyDiscount(double originalPrice, String userId);
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć

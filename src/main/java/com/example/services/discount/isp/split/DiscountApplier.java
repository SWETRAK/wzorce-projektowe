package com.example.services.discount.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa DiscountApplier jako interfejs do stosowania rabatów
public interface DiscountApplier {
    double calculateDiscount(String userId, double orderAmount);
    void applyDiscountToOrder(String orderId, double discountAmount);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

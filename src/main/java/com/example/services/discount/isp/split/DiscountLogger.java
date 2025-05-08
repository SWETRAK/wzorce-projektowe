package com.example.services.discount.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa DiscountApplier jako interfejs do logowania rabatów
public interface DiscountLogger {
    void logDiscount(String orderId, String userId, double discountAmount, double originalAmount);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
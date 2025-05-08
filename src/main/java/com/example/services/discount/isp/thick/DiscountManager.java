package com.example.services.discount.isp.thick;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa DiscountManager jako gruby interfejs do zarządzania rabatami
public interface DiscountManager {
    double calculateDiscount(String userId, double orderAmount);
    void applyDiscount(String orderId, double discountAmount);
    void logDiscountApplication(String orderId, String userId, double discountAmount);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

package com.example.services.discount.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Implementacja DiscountLogger
public class DiscountLoggerImpl implements DiscountLogger {
    @Override
    public void logDiscount(String orderId, String userId, double discountAmount, double originalAmount) {
        System.out.println("Discount applied: Order ID: " + orderId + ", User ID: " + userId +
                ", Discount Amount: " + discountAmount + ", Original Amount: " + originalAmount);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

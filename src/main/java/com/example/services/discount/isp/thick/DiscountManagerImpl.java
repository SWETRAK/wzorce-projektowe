package com.example.services.discount.isp.thick;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Implementajca DiscountManager
public class DiscountManagerImpl implements DiscountManager {
    @Override
    public double calculateDiscount(String userId, double orderAmount) {
        return orderAmount * 0.1;
    }

    @Override
    public void applyDiscount(String orderId, double discountAmount) {
        System.out.println("Applying discount of " + discountAmount + " to order " + orderId);
    }

    @Override
    public void logDiscountApplication(String orderId, String userId, double discountAmount) {
        System.out.println("Logging discount application: Order ID: " + orderId + ", User ID: " + userId + ", Discount Amount: " + discountAmount);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

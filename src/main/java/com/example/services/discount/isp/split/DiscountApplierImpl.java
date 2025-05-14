package com.example.services.discount.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Implementacja DiscountApplier
public class DiscountApplierImpl implements DiscountApplier {

    private final static double DISCOUNT_VALUE = 0.1;

    @Override
    public double calculateDiscount(String userId, double orderAmount) {
        return orderAmount * DISCOUNT_VALUE;
    }

    @Override
    public void applyDiscountToOrder(String orderId, double discountAmount) {
        System.out.println("Applying discount of " + discountAmount + " to order " + orderId);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

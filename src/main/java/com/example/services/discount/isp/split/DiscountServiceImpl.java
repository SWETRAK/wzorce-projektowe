package com.example.services.discount.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa korzystająca z 2 interfejsów: DiscountApplier i DiscountLogger
public class DiscountServiceImpl implements DiscountApplier, DiscountLogger {
    private final DiscountApplier discountApplier;
    private final DiscountLogger discountLogger;

    public DiscountServiceImpl(DiscountApplier discountApplier, DiscountLogger discountLogger) {
        this.discountApplier = discountApplier;
        this.discountLogger = discountLogger;
    }

    @Override
    public double calculateDiscount(String userId, double orderAmount) {
        return discountApplier.calculateDiscount(userId, orderAmount);
    }

    @Override
    public void applyDiscountToOrder(String orderId, double discountAmount) {
        discountApplier.applyDiscountToOrder(orderId, discountAmount);
    }

    @Override
    public void logDiscount(String orderId, String userId, double discountAmount, double originalAmount) {
        discountLogger.logDiscount(orderId, userId, discountAmount, originalAmount);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

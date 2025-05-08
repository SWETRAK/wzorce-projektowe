package com.example.services.discount.dip;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// LoyaltyDiscount jako konkretna implementacja rabatu lojalnościowego
public class LoyaltyDiscount extends BaseDiscount {
    private static final double LOYALTY_DISCOUNT_RATE = 0.05;

    public LoyaltyDiscount(double discountPercentage) {
        super(discountPercentage);
    }

    @Override
    public double applyDiscount(double originalPrice, String userId) {
        double discount = originalPrice * LOYALTY_DISCOUNT_RATE;
        double discountedPrice = originalPrice - discount;
        System.out.println("Applying Loyalty Discount for User " + userId + ": " + String.format("%.2f", discount) + " off. New price: " + String.format("%.2f", discountedPrice));
        return discountedPrice;
    }

    @Override
    public void logDiscount(String orderId, String userId, double discountAmount, double originalAmount) {
        System.out.println("Logging Loyalty Discount for Order ID: " + orderId + ", User ID: " + userId + ", Discount Amount: " + String.format("%.2f", discountAmount) + ", Original Amount: " + String.format("%.2f", originalAmount));
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending notification to " + recipient + ": " + message);
    }

    @Override
    public void generateInvoice(String orderId, double amount) {
        System.out.println("Generating invoice for Order ID: " + orderId + " with amount: " + String.format("%.2f", amount));
        System.out.println("Invoice generated successfully for Order ID: " + orderId + " with amount: " + String.format("%.2f", amount));
    }
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć

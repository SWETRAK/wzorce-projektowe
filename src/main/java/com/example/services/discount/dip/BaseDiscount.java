package com.example.services.discount.dip;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// BaseDiscount jako abstrakcja implementująca wspólną logikę dla różnych strategii rabatowych
public abstract class BaseDiscount implements DiscountStrategy{
    protected double discountPercentage;

    public BaseDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double originalPrice, String userId) {
        return originalPrice - (originalPrice * discountPercentage / 100);
    }

    public abstract void logDiscount(String orderId, String userId, double discountAmount, double originalAmount);

    public abstract void sendNotification(String recipient, String message);

    public abstract void generateInvoice(String orderId, double amount);
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
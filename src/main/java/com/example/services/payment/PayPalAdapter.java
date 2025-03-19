package com.example.services.payment;

// Tydzień 3, Wzorzec Adapter, Joanna Kozar
// Adapter pozwalający na użycie systemu PayPal jako procesora płatności
public class PayPalAdapter implements PaymentProcessor {
    private final PayPalPayment paypal;

    public PayPalAdapter(PayPalPayment paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}
// Koniec - Tydzień 3, Wzorzec Adapter, Joanna Kozar

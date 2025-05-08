package com.example.services.payment;

// Tydzień 3, Wzorzec Adapter, Joanna Kozar
// Adapter pozwalający na użycie systemu Blik jako procesora płatności

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Płatność BLIK
public class BlikAdapter implements PaymentProcessor{
    private final BlikPayment blik;

    public BlikAdapter(BlikPayment blik) {
        this.blik = blik;
    }

    @Override
    public void processPayment(double amount) {
        blik.pay(amount);
    }
}
// Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
// Koniec - Tydzień 3, Wzorzec Adapter, Joanna Kozar


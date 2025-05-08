package com.example.services.payment;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Abstrakcyjna metoda płatności
public abstract class PaymentMethod {
    public abstract void processPayment(double amount);
}
// Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
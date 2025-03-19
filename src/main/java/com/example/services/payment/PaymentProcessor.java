package com.example.services.payment;

// Tydzień 3, Wzorzec Adapter, Joanna Kozar
// Interfejs procesora płatności umożliwiający jednolitą obsługę różnych systemów
public interface PaymentProcessor {
    void processPayment(double amount);
}
//Koniec - Tydzień 3, Wzorzec Adapter, Joanna Kozar

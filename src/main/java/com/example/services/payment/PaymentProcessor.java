package com.example.services.payment;

// Tydzień 3, Wzorzec Adapter, Joanna Kozar
// Interfejs procesora płatności umożliwiający jednolitą obsługę różnych systemów

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Interfejs metody płatności
public interface PaymentProcessor {
    void processPayment(double amount);
}
//Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
//Koniec - Tydzień 3, Wzorzec Adapter, Joanna Kozar

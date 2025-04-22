package com.example.services.payment;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Płatność BLIK
public class BLIK extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Przetwarzanie płatności BLIK: " + amount + " PLN");
    }
}
//Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
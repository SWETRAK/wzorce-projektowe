package com.example.services.payment.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa CardPayment dziedzicząca po PaymentMethod
public class CardPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Płatność kartą: " + amount);
    }
}
//Koniec - Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
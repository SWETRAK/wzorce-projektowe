package com.example.services.payment.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa BlikPayment dziedzicząca po PaymentMethod
public class BlikPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Płatność BLIK: " + amount);
    }
}
//Koniec - Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
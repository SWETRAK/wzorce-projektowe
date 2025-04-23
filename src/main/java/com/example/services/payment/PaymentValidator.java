package com.example.services.payment;

// Tydzień 7, Single Responsibility Principle, Joanna Kozar
// Klasa odpowiada tylko za walidację płatności
public class PaymentValidator {
    public boolean validate(String paymentData) {
        System.out.println("Waliduję płatność dla danych: " + paymentData);
        return paymentData != null && !paymentData.isEmpty();
    }
}
// Koniec - Tydzień 7, Single Responsibility Principle, Joanna Kozar
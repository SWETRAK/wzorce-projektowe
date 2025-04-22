package com.example.services.payment;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Płatność PayPal
public class PayPal extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Przetwarzanie płatności PayPal: " + amount + " PLN");
    }
}
//Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
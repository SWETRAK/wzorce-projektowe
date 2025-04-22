package com.example.services.payment;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Płatność kartą kredytową
public class Card extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Przetwarzanie płatności kartą: " + amount + " PLN");
    }
}
//Koniec -  Tydzień 7, Open/Closed Principle, Joanna Kozar
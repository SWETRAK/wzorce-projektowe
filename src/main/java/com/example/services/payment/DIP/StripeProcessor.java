package com.example.services.payment.DIP;

// Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
// Klasa StripeProcessor implementująca interfejs PaymentProcessor
public class StripeProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Stripe przetwarza płatność: " + amount);
    }
}
//Koniec - Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
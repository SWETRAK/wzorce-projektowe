package com.example.services.payment;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Płatność kartą kredytową
public class CardAdapter implements PaymentProcessor{
    private final CardPayment card;

    public CardAdapter(CardPayment card) {
        this.card = card;
    }

    @Override
    public void processPayment(double amount) {
        card.pay(amount);
    }
}
//Koniec -  Tydzień 7, Open/Closed Principle, Joanna Kozar
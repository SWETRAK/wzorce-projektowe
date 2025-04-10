package com.example.services.payment;

//Tydzień 6, wzorzec Template, Joanna Kozar
//Implementacja klasy płatności kartą
public class CardPaymentTemplate extends PaymentTemplate {
    protected void authenticate() {
        System.out.println("Autoryzacja karty kredytowej...");
    }

    protected void makePayment(double amount) {
        System.out.println("Płatność kartą została zrealizowana." + amount);
    }
}
//Koniec - Tydzień 6, wzorzec Template, Joanna Kozar

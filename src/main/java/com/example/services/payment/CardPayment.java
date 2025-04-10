package com.example.services.payment;

//Tydzień 6, wzorzec Template, Joanna Kozar
//Implementacja klasy płatności kartą
public class CardPayment extends PaymentTemplate {
    protected void authenticate() {
        System.out.println("Autoryzacja karty kredytowej...");
    }

    protected void makePayment() {
        System.out.println("Płatność kartą została zrealizowana.");
    }
}
//Koniec - Tydzień 6, wzorzec Template, Joanna Kozar

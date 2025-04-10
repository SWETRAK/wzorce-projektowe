package com.example.services.payment;

//Tydzień 6, wzorzec Template, Joanna Kozar
//Implementacja klasy płatności blikiem
public class BlikPaymentTemplate extends PaymentTemplate {
    private final BlikAdapter adapter;

    public BlikPaymentTemplate(BlikAdapter adapter) {
        this.adapter = adapter;
    }

    protected void authenticate() {
        System.out.println("Wprowadzono kod BLIK...");
    }

    protected void makePayment(double amount) {
        adapter.processPayment(amount);

        System.out.println("Płatność BLIK została zrealizowana.");
    }
}
//Koniec - Tydzień 6, wzorzec Template, Joanna Kozar

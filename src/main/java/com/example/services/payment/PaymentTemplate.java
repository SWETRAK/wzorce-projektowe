package com.example.services.payment;

//Tydzień 6, wzorzec Template, Joanna Kozar
//Implementacja klasy typu abstract do procesów płatności
public abstract class PaymentTemplate {
    public final void processPayment(double amount) {
        authenticate();
        makePayment(amount);
        sendConfirmation();
    }

    protected abstract void authenticate();
    protected abstract void makePayment(double amount);

    protected void sendConfirmation() {
        System.out.println("Wysłano potwierdzenie płatności.");
    }
}
//Koniec - Tydzień 6, wzorzec Template, Joanna Kozar
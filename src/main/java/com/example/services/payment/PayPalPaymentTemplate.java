package com.example.services.payment;

public class PayPalPaymentTemplate extends PaymentTemplate{
    private final PayPalAdapter adapter;

    public PayPalPaymentTemplate(PayPalAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected void authenticate() {
        System.out.println("Wprowadzono dane PayPal ...");
    }

    @Override
    protected void makePayment(double amount) {
        adapter.processPayment(amount);

        System.out.println("Płatność PayPal została zrealizowana.");
    }
}

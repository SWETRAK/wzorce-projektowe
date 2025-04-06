package com.example.services.order.template;

// Tydzień 6, Wzorzec Template Method, Maciej Potręć
// Klasa reprezentująca proces przetwarzania zamówienia na audiobooki.
public class AudioBookOrderProcessor extends OrderProcessor {
    @Override
    protected void deliver(String orderId) {
        System.out.println("Setting up streaming access for audiobook order: " + orderId);
        System.out.println("Sending email with streaming instructions");
    }

    @Override
    protected void handleAdditionalServices(String orderId) {
        System.out.println("Offering companion PDF material for audiobook order: " + orderId);
    }
}
// Koniec, Tydzień 6, Wzorzec Template Method, Maciej Potręć

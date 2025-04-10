package com.example.services.order.template;

// Tydzień 6, Wzorzec Template Method, Maciej Potręć
// Klasa reprezentująca proces przetwarzania zamówienia na e-booki.
public class EbookOrderProcessor extends OrderProcessor {
    @Override
    protected void deliver(String orderId) {
        System.out.println("Generating download link for e-book order: " + orderId);
        System.out.println("Sending email with download instructions");
    }

    @Override
    protected boolean offerAdditionalServices() {
        return false;
    }
}
// Koniec, Tydzień 6, Wzorzec Template Method, Maciej Potręć
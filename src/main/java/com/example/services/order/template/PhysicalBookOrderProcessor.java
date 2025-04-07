package com.example.services.order.template;

// Tydzień 6, Wzorzec Template Method, Maciej Potręć
// Klasa reprezentująca proces przetwarzania zamówienia na książki fizyczne.
public class PhysicalBookOrderProcessor extends OrderProcessor {
    @Override
    protected void deliver(String orderId) {
        System.out.println("Packaging physical book for shipping for order: " + orderId);
        System.out.println("Dispatching book to shipping carrier");
    }

    @Override
    protected void handleAdditionalServices(String orderId) {
        System.out.println("Offering gift wrapping service for physical book order: " + orderId);
    }
}
// Koniec, Tydzień 6, Wzorzec Template Method, Maciej Potręć

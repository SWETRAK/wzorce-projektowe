package com.example.services.delivery.startegies;

// Tydzień 6, Wzorzec Strategy, Kamil Pietrak
// Klasa kontekstu używająca strategii dostawy
public class DeliveryContext {
    private DeliveryStrategy strategy;

    public void setStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeDelivery(String packageId) {
        strategy.deliver(packageId);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy, Kamil Pietrak

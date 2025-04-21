package com.example.services.delivery.startegies;

import com.example.services.delivery.InPostServiceAdapter;

// Tydzień 6, Wzorzec Strategy, Kamil Pietrak
// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Implementacja strategii dostawy do paczkomatu
public class InPostStrategy implements DeliveryStrategy {

    private final InPostServiceAdapter deliveryService;

    public InPostStrategy(InPostServiceAdapter deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void deliver(String packageId) {
        this.deliveryService.deliverOrder(packageId);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy, Kamil Pietrak
// Koniec, Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
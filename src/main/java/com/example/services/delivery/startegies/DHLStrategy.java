package com.example.services.delivery.startegies;

import com.example.services.delivery.DHLServiceAdapter;
import com.example.services.delivery.DeliveryService;

// Tydzień 6, Wzorzec Strategy, Kamil Pietrak
// Implementacja strategii dostawy do paczkomatu
public class DHLStrategy implements DeliveryStrategy{

    private final DHLServiceAdapter deliveryService;

    public DHLStrategy(DHLServiceAdapter deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public void deliver(String packageId) {
        this.deliveryService.deliverOrder(packageId);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy, Kamil Pietrak

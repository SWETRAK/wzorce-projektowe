package com.example.services.delivery.processes;

import com.example.services.delivery.DHLServiceAdapter;
import com.example.services.delivery.startegies.DHLStrategy;
import com.example.services.delivery.startegies.DeliveryContext;

// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Implementacja strategii dostawy przez kuriera
public class DHLDeliver implements DeliverProcess {
    private final DeliveryContext context;
    private final DHLServiceAdapter deliveryService;

    public DHLDeliver(DeliveryContext context, DHLServiceAdapter deliveryService) {
        this.context = context;
        this.deliveryService = deliveryService;
    }

    @Override
    public void process(String packageId) {
        this.context.setStrategy(new DHLStrategy(this.deliveryService));
        this.context.executeDelivery(packageId);
    }
}
// Koniec, Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
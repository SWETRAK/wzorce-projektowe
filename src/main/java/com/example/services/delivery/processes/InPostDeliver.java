package com.example.services.delivery.processes;

import com.example.services.delivery.InPostServiceAdapter;
import com.example.services.delivery.startegies.DeliveryContext;
import com.example.services.delivery.startegies.InPostStrategy;

// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Implementacja strategii dostawy do paczkomatu
public class InPostDeliver implements DeliverProcess {

    private final DeliveryContext context;
    private final InPostServiceAdapter deliveryService;

    public InPostDeliver(DeliveryContext context, InPostServiceAdapter deliveryService) {
        this.context = context;
        this.deliveryService = deliveryService;
    }

    @Override
    public void process(String packageId) {
        this.context.setStrategy(new InPostStrategy(this.deliveryService));
        this.context.executeDelivery(packageId);
    }
}
// Koniec, Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
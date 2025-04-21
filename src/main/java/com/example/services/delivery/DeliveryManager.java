package com.example.services.delivery;

import com.example.services.delivery.processes.DHLDeliver;
import com.example.services.delivery.processes.InPostDeliver;
import com.example.services.delivery.processes.DeliverProcess;
import com.example.services.delivery.processes.DeliveryType;
import com.example.services.delivery.startegies.DeliveryContext;

import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Klasa zarządzająca strategiami dostawy (sterowanie danymi)
public class DeliveryManager {

    private final Map<DeliveryType, DeliverProcess> deliveryMethods = new HashMap<>();

    public DeliveryManager(
            DHLServiceAdapter dhlServiceAdapter,
            InPostServiceAdapter inPostServiceAdapter,
            DeliveryContext deliveryContext) {

        deliveryMethods.put(DeliveryType.DHL, new DHLDeliver(deliveryContext, dhlServiceAdapter));
        deliveryMethods.put(DeliveryType.INPOST, new InPostDeliver(deliveryContext, inPostServiceAdapter));
    }

    public void deliver(Map<DeliveryType, String> packages) {
        for (Map.Entry<DeliveryType, String> entry : packages.entrySet()) {
            DeliverProcess process = deliveryMethods.get(entry.getKey());
            if (process != null) {
                process.process(entry.getValue());
            } else {
                System.out.println("Unknown shipping type: " + entry.getKey().toString());
            }
        }
    }
}
// Koniec, Tydzień 7, Zasada OCP, Kamil Pietrak

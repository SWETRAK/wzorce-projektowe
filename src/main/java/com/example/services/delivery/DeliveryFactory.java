package com.example.services.delivery;

import com.example.models.delivery.DeliveryInfo;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Kamil Pietrak
// Klasa cash`ująca dane o wysyłkach
public class DeliveryFactory {

    private static final Map<String, DeliveryInfo> deliveries = new HashMap<>();

    public static DeliveryInfo getDeliveryInfo(String courierName, String trackingNumber) {
        if (!deliveries.containsKey(trackingNumber)) {

            deliveries.put(trackingNumber, new DeliveryInfo(courierName, trackingNumber));
        }
        return deliveries.get(trackingNumber);
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Kamil Pietrak
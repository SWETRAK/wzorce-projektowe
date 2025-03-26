package com.example.services.order.facade;

import com.example.models.users.Client;
import com.example.services.delivery.DeliveryService;

// Tydzień 4, Wzorzec Fasada, Maciej Potręć
// Klasa zarządzająca dostawą
public class ShippingManager {
    public void arrangeShipping(Client client, DeliveryService deliveryService, String orderId) {
        System.out.println("Arranging shipping for order " + orderId + " to address: " + client.getAddress());

        deliveryService.deliverOrder(orderId);
    }
}
// Koniec, Tydzień 4, Wzorzec Fasada, Maciej Potręć
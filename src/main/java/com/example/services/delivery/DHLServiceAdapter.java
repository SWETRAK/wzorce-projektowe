package com.example.services.delivery;

import com.example.services.external.DHLDeliveryService;

// Tydzień 3, Wzorzec Adapter, Kamil Pietrak
// Klasa adaptera dla wysyłek DHL korzystająca z "zewnętrznego serwisu". Dostosowuje "zewnętrzną" bibliotekę do designu systemu
public class DHLServiceAdapter implements DeliveryService {

    private final DHLDeliveryService deliveryService = new DHLDeliveryService();

    @Override
    public void deliverOrder(String orderId) {
        deliveryService.deliverOrder(orderId);
    }

    @Override
    public void getOrderStatus(String orderId) {
        deliveryService.getOrderStatus(orderId);
    }
}

// Koniec, Tydzień 3, Wzorzec Adapter, Kamil Pietrak

package com.example.services.delivery;

import com.example.services.external.InPostDeliveryService;

// Tydzień 3, Wzorzec Adapter, Kamil Pietrak
// Klasa adaptera dla wysyłek InPost korzystająca z "zewnętrznego serwisu". Dostosowuje "zewnętrzną" bibliotekę do designu systemu
public class InPostServiceAdapter implements DeliveryService{

    private final InPostDeliveryService inPostDeliveryService = new InPostDeliveryService();

    @Override
    public void deliverOrder(String orderId) {
        inPostDeliveryService.deliver(orderId);
    }

    @Override
    public void getOrderStatus(String orderId) {
        inPostDeliveryService.getStatus(orderId);
    }
}
// Koniec, Tydzień 3, Wzorzec Adapter, Kamil Pietrak
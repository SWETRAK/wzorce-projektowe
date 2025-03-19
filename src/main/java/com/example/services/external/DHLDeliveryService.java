package com.example.services.external;

// Tydzień 2, Wzorzec Adapter, Kamil Pietrak
// "Zewnetrzny" dostawca usług DHL
public class DHLDeliveryService {

    public void deliverOrder(String orderId) {
        System.out.println("Delivering order via DHL service: " + orderId);
    }

    public void getOrderStatus(String orderId) {
        System.out.println("Getting order via DHL service: " + orderId);
    }
}
// Koniec, Tydzień 2, Wzorzec Adapter, Kamil Pietrak
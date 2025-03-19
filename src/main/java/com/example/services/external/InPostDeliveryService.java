package com.example.services.external;

// Tydzień 2, Wzorzec Adapter, Kamil Pietrak
// "Zewnetrzny" dostawca usług InPost
public class InPostDeliveryService {
    public void deliver(String orderId) {
        System.out.println("Delivering order via InPost service: " + orderId);
    }

    public void getStatus(String orderId) {
        System.out.println("Getting order status via InPost service: " + orderId);
    }
}
// Koniec, Tydzień 2, Wzorzec Adapter, Kamil Pietrak

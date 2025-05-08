package com.example.services.order.handler;

import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;

// Tydzień 7, Zasada OC, Maciej Potręć
// Klasa odpowiedzialna za obsługę zamówień fizycznych
public class PhysicalOrderHandler implements OrderHandler {
    @Override
    public void processOrder(String orderId, Client client, ShoppingCart cart) {
        System.out.println("Processing physical order: " + orderId);
        System.out.println("Preparing items for shipping to: " + client.getAddress());
        System.out.println("Total items: " + cart.getPrice());
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("Cancelling physical order: " + orderId);
        System.out.println("Stopping shipment process and returning items to inventory");
    }

    @Override
    public String getOrderStatus(String orderId) {
        return "Physical order " + orderId + " is being processed for shipment";
    }
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

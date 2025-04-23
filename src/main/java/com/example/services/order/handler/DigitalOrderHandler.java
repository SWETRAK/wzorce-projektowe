package com.example.services.order.handler;

import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;

// Tydzień 7, Zasada OC, Maciej Potręć
// Klasa odpowiedzialna za obsługę zamówień cyfrowych
public class DigitalOrderHandler implements OrderHandler {
    @Override
    public void processOrder(String orderId, Client client, ShoppingCart cart) {
        System.out.println("Processing digital order: " + orderId);
        System.out.println("Preparing digital content for: " + client.getEmail());
        System.out.println("Total items: " + cart.getPrice());
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("Cancelling digital order: " + orderId);
        System.out.println("Revoking access to digital content");
    }

    @Override
    public String getOrderStatus(String orderId) {
        return "Digital order " + orderId + " is being prepared for download";
    }
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

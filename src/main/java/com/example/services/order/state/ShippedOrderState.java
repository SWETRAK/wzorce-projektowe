package com.example.services.order.state;

import com.example.services.order.Order;

// Tydzień 6, Wzorzec State, Maciej Potręć
// Klasa reprezentująca stan zamówienia, gdy zostało ono wysłane
public class ShippedOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() + " has already been processed");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() + " has already been shipped");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivering order #" + order.getOrderId());
        order.setState(new DeliveredOrderState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Cannot cancel order #" + order.getOrderId() + " - it has already been shipped");
    }

    @Override
    public String getStateName() {
        return "Shipped";
    }
}
// Koniec, Tydzień 6, Wzorzec State, Maciej Potręć
package com.example.services.order.state;

import com.example.services.order.Order;

// Tydzień 6, Wzorzec State, Maciej Potręć
// Klasa reprezentująca stan zamówienia, gdy zostało ono dostarczone
public class DeliveredOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() + " has already been delivered");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() + " has already been delivered");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() + " has already been delivered");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Cannot cancel order #" + order.getOrderId() + " - it has already been delivered");
    }

    @Override
    public String getStateName() {
        return "Delivered";
    }
}
// Koniec, Tydzień 6, Wzorzec State, Maciej Potręć

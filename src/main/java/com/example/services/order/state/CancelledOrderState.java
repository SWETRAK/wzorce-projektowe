package com.example.services.order.state;

import com.example.services.order.Order;

// Tydzień 6, Wzorzec State, Maciej Potręć
// Klasa reprezentująca stan zamówienia, gdy zostało ono anulowane
public class CancelledOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Cannot process order #" + order.getOrderId() + " - it has been cancelled");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Cannot ship order #" + order.getOrderId() + " - it has been cancelled");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver order #" + order.getOrderId() + " - it has been cancelled");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() + " is already cancelled");
    }

    @Override
    public String getStateName() {
        return "Cancelled";
    }
}
// Koniec, Tydzień 6, Wzorzec State, Maciej Potręć

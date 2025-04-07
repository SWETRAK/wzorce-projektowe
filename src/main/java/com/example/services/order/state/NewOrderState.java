package com.example.services.order.state;

import com.example.services.order.Order;

// Tydzień 6, Wzorzec State, Maciej Potręć
// Klasa reprezentująca stan zamówienia, gdy zostało ono złożone
public class NewOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Processing order #" + order.getOrderId());
        order.setState(new ProcessingOrderState());
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Cannot ship order #" + order.getOrderId() + " - it needs to be processed first");
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver order #" + order.getOrderId() + " - it needs to be processed and shipped first");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Cancelling order #" + order.getOrderId());
        order.setState(new CancelledOrderState());
    }

    @Override
    public String getStateName() {
        return "New";
    }
}
// Koniec, Tydzień 6, Wzorzec State, Maciej Potręć

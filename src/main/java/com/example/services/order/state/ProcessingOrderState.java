package com.example.services.order.state;

import com.example.services.order.Order;

// Tydzień 6, Wzorzec State, Maciej Potręć
public class ProcessingOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() + " is already being processed");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Shipping order #" + order.getOrderId());
        order.setState(new ShippedOrderState());
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver order #" + order.getOrderId() + " - it needs to be shipped first");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Cancelling order #" + order.getOrderId() + " during processing");
        order.setState(new CancelledOrderState());
    }

    @Override
    public String getStateName() {
        return "Processing";
    }
}
// Koniec, Tydzień 6, Wzorzec State, Maciej Potręć
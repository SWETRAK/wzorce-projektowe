package com.example.services.order.state;

import com.example.services.order.BasicOrder;

import java.util.HashMap;
import java.util.Map;

// Tydzień 6, Wzorzec State, Maciej Potręć
// State - klasa zarządzająca stanem zamówienia
public class OrderStateService {
    private final Map<String, BasicOrder> orders = new HashMap<>();
    private static OrderStateService instance;

    private OrderStateService() {
    }

    public static OrderStateService getInstance() {
        if (instance == null) {
            instance = new OrderStateService();
        }
        return instance;
    }

    public BasicOrder createOrder(String customerEmail, double totalAmount) {
        String orderId = "ORD-" + System.currentTimeMillis();
        BasicOrder order = new BasicOrder(orderId, totalAmount);
        orders.put(orderId, order);
        return order;
    }

    public BasicOrder getOrder(String orderId) {
        return orders.get(orderId);
    }

    public void processOrder(String orderId) {
        BasicOrder order = getOrder(orderId);
        if (order != null) {
            order.process();
        } else {
            System.out.println("Order " + orderId + " not found");
        }
    }

    public void shipOrder(String orderId) {
        BasicOrder order = getOrder(orderId);
        if (order != null) {
            order.ship();
        } else {
            System.out.println("Order " + orderId + " not found");
        }
    }

    public void deliverOrder(String orderId) {
        BasicOrder order = getOrder(orderId);
        if (order != null) {
            order.deliver();
        } else {
            System.out.println("Order " + orderId + " not found");
        }
    }

    public void cancelOrder(String orderId) {
        BasicOrder order = getOrder(orderId);
        if (order != null) {
            order.cancel();
        } else {
            System.out.println("Order " + orderId + " not found");
        }
    }

    public void printOrderStatus(String orderId) {
        BasicOrder order = getOrder(orderId);
        if (order != null) {
            System.out.println("Order #" + order.getOrderId() + " - Status: " +
                    order.getState().getStateName() + " - Cost: $" + order.calculateCost());
        } else {
            System.out.println("Order " + orderId + " not found");
        }
    }
}
// Koniec, Tydzień 5, Wzorzec State, Maciej Potręć`

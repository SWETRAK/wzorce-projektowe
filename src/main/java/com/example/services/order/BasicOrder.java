package com.example.services.order;

import com.example.services.order.state.NewOrderState;
import com.example.services.order.state.OrderState;
import lombok.Getter;

// Tydzień 3, Wzorzec Decorator, Maciej Potręć
// Konkretny komponent - podstawowe zamówienie
@Getter
public class BasicOrder implements Order {
    private final String orderId;
    private final double baseCost;
    private OrderState state;

    public BasicOrder(String orderId, double baseCost) {
        this.orderId = orderId;
        this.baseCost = baseCost;
        this.state = new NewOrderState();
        System.out.println("Created new order #" + orderId + " in state: " + state.getStateName());
    }

    public void setState(OrderState state) {
        this.state = state;
        System.out.println("Order #" + orderId + " changed state to: " + state.getStateName());
    }

    public void ship() {
        state.shipOrder(this);
    }

    public void deliver() {
        state.deliverOrder(this);
    }

    public void cancel() {
        state.cancelOrder(this);
    }

    @Override
    public String getDescription() {
        return "Basic order #" + orderId;
    }

    @Override
    public double calculateCost() {
        return baseCost;
    }

    @Override
    public void process() {
        state.processOrder(this);
        System.out.println("Processing " + getDescription());
        System.out.println("Total cost: $" + calculateCost());
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Maciej Potręć

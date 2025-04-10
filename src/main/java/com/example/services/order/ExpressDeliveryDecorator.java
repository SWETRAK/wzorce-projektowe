package com.example.services.order;

import com.example.services.order.state.OrderState;

// Tydzień 3, Wzorzec Decorator, Maciej Potręć
// Konkretny dekorator - dodaje funkcjonalność ekspresowej dostawy
public class ExpressDeliveryDecorator extends OrderDecorator {
    private final double expressFee;

    public ExpressDeliveryDecorator(Order decoratedOrder, double expressFee) {
        super(decoratedOrder);
        this.expressFee = expressFee;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + " with express delivery";
    }

    @Override
    public String getOrderId() {
        return decoratedOrder.getOrderId();
    }

    @Override
    public double calculateCost() {
        return decoratedOrder.calculateCost() + expressFee;
    }

    @Override
    public void process() {
        super.process();
        System.out.println("Added express delivery for $" + expressFee);
    }

    @Override
    public void setState(OrderState state) {
        System.out.println("Express delivery state changed to: " + state.getStateName());
        decoratedOrder.setState(state);
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Maciej Potręć

package com.example.services.order;

import com.example.services.order.state.OrderState;

// Tydzień 3, Wzorzec Decorator, Maciej Potręć
// Konkretny dekorator - dodaje funkcjonalność pakowania prezentu
public class GiftWrappingDecorator extends OrderDecorator {
    private final double wrappingFee;

    public GiftWrappingDecorator(Order decoratedOrder, double wrappingFee) {
        super(decoratedOrder);
        this.wrappingFee = wrappingFee;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + " with gift wrapping";
    }

    @Override
    public String getOrderId() {
        return decoratedOrder.getOrderId();
    }

    @Override
    public double calculateCost() {
        return decoratedOrder.calculateCost() + wrappingFee;
    }

    @Override
    public void process() {
        super.process();
        System.out.println("Added gift wrapping for $" + wrappingFee);
    }

    @Override
    public void setState(OrderState state) {
        System.out.println("Gift wrapping state changed to: " + state.getStateName());
        decoratedOrder.setState(state);
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Maciej Potręć

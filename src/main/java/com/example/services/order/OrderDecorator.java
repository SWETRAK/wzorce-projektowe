package com.example.services.order;

// Tydzień 3, Wzorzec Decorator, Maciej Potręć
// Dekorator bazowy - utrzymuje odniesienie do dekorowanego obiektu i deleguje do niego operacje
public abstract class OrderDecorator implements Order {
    protected Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription();
    }

    @Override
    public double calculateCost() {
        return decoratedOrder.calculateCost();
    }

    @Override
    public void process() {
        decoratedOrder.process();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Maciej Potręć

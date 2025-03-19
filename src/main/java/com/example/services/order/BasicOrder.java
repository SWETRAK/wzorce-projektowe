package com.example.services.order;

// Tydzień 3, Wzorzec Decorator, Maciej Potręć
// Konkretny komponent - podstawowe zamówienie
public class BasicOrder implements Order {
    private final String orderId;
    private final double baseCost;

    public BasicOrder(String orderId, double baseCost) {
        this.orderId = orderId;
        this.baseCost = baseCost;
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
        System.out.println("Processing " + getDescription());
        System.out.println("Total cost: $" + calculateCost());
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Maciej Potręć

package com.example.services.order;

import com.example.services.order.state.OrderState;

// Tydzień 3, Wzorzec Decorator, Maciej Potręć
// Interfejs komponentu - podstawowa funkcjonalność zamówienia
public interface Order {
    String getDescription();
    String getOrderId();
    double calculateCost();
    void process();
    void setState(OrderState state);
}
// Koniec, Tydzień 3, Wzorzec Decorator, Maciej Potręć

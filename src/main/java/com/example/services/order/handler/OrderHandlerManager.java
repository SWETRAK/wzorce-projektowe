package com.example.services.order.handler;

import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OC, Maciej Potręć
// Klasa odpowiedzialna za zarządzanie handlerami zamówień
public class OrderHandlerManager {
    private final Map<OrderType, OrderHandler> handlers = new HashMap<>();

    public OrderHandlerManager() {
        handlers.put(OrderType.PHYSICAL, new PhysicalOrderHandler());
        handlers.put(OrderType.DIGITAL, new DigitalOrderHandler());
    }

    public OrderHandler getHandler(OrderType type) {
        OrderHandler handler = handlers.get(type);
        if (handler == null) {
            throw new IllegalArgumentException("Unsupported order type: " + type);
        }
        return handler;
    }
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

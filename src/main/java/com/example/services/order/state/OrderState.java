package com.example.services.order.state;

import com.example.services.order.Order;

// Tydzień 6, Wzorzec State, Maciej Potręć
// Interfejs definiujący metody do obsługi różnych stanów zamówienia
public interface OrderState {
    void processOrder(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
    void cancelOrder(Order order);
    String getStateName();
}
// Koniec, Tydzień 6, Wzorzec State, Maciej Potręć
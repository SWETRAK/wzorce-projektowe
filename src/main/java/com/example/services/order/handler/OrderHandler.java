package com.example.services.order.handler;

import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;

// Tydzień 7, Zasada OC, Maciej Potręć
// Interfejs odpowiedzialny za obsługę zamówień
public interface OrderHandler {
    void processOrder(String orderId, Client client, ShoppingCart cart);
    void cancelOrder(String orderId);
    String getOrderStatus(String orderId);
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

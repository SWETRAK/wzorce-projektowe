package com.example.services.order.ISP;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Podzielony interfejs OrderCreator
public interface OrderCreator {
    void createOrder(String isbn);
    void cancelOrder(String id);
}
//Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
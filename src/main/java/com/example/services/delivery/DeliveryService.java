package com.example.services.delivery;


// Tydzień 3, Wzorzec Adapter, Kamil Pietrak
// Interfejs reprezentujący funkcjonalności wysyłek paczek
public interface DeliveryService {
    void deliverOrder(String orderId);

    void getOrderStatus(String orderId);
}
// Koniec, Tydzień 3, Wzorzec Adapter, Kamil Pietrak
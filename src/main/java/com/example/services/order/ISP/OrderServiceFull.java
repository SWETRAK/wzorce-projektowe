package com.example.services.order.ISP;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Gruby interfejs OrderServiceFull
public interface OrderServiceFull {
    void createOrder(String isbn);
    void cancelOrder(String id);
    void viewStatus(String id);
}
//Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
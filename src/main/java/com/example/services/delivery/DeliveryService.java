package com.example.services.delivery;

// Tydzień 3, Wzorzec Adapter, Kamil Pietrak
// Interfejs reprezentujący funkcjonalności wysyłek paczek
// Tydzień 8, Zasada Podstawienia Liskov (LSP), Kamil Pietrak
// DeliveryService jako interfejs bazowy dla sposobów dostawy: kurierska i paczkomatowa.
// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// DeliveryService jako abstrakcja operacji dostawy dla klas wyższego poziomu.
public interface DeliveryService {
    void deliverOrder(String orderId);

    void getOrderStatus(String orderId);
}
// Koniec, Tydzień 8, Zasada Podstawienia Liskov, Kamil Pietrak
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// Koniec, Tydzień 3, Wzorzec Adapter, Kamil Pietrak
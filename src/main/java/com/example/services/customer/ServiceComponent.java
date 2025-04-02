package com.example.services.customer;

// Tydzień 5, Wzorzec Mediator, Maciej Potręć
// Interfejs reprezentujący komponenty systemu obsługi klienta
public interface ServiceComponent {
    void receiveQuery(String query, String customerId);
    void sendQuery(String query, String customerId);
    String getName();
}
// Koniec, Tydzień 5, Wzorzec Mediator, Maciej Potręć

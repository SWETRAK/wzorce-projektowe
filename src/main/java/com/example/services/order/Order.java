package com.example.services.order;

// Tydzień 3, Wzorzec Decorator, Maciej Potręć
// Interfejs komponentu - podstawowa funkcjonalność zamówienia
public interface Order {
    String getDescription();
    double calculateCost();
    void process();
}
// Koniec, Tydzień 3, Wzorzec Decorator, Maciej Potręć

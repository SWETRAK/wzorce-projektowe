package com.example.services.delivery.processes;

// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Interfejs reprezentuje strategię dostawy pakietów
public interface DeliverProcess {
    void process(String packageId);
}
// Koniec, Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
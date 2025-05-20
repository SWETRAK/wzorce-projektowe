package com.example.functional.interfaces;

//Tydzień 10, Zasada Programowanie Funkcyjne, Kamil Pietrak
//Interfejs funkcyjny do wysyłania książek
@FunctionalInterface
public interface DeliveryNotifier {
    void notify(String packageId);
}
//Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Kamil Pietrak
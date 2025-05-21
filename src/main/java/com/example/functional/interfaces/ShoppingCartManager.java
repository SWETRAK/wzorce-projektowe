package com.example.functional.interfaces;

//Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
//Interfejs funkcyjny do obsługi koszyka zakupowego
@FunctionalInterface
public interface ShoppingCartManager {
    void manageCart(String cartContent, String invoiceContent, String stockContent);
}
//Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
package com.example.functional.interfaces;

//Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
//Interfejs funkcyjny do walidowania pozycji magazynowych
@FunctionalInterface
public interface StockValidator {
    boolean validate(String stockItem, int quantity);
}
//Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć

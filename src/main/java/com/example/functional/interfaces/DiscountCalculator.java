package com.example.functional.interfaces;

//Tydzień 10, Zasada Programowanie Funkcyjne, Joanna Kozar
//Interfejs funkcyjny do obliczania zniżek
@FunctionalInterface
public interface DiscountCalculator {
    double calculate(double price);
}
//Koniec - Tydzień 10, Zasada Programowanie Funkcyjne, Joanna Kozar
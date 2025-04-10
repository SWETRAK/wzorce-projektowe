package com.example.services.discount;

//Tydzień 6, wzorzec Strategy, Joanna Kozar
//Implementacja interfejscu do promocji zależnych od typu klienta
public interface DiscountStrategy {
    double applyDiscount(double price);
}
//Koniec - Tydzień 6, wzorzec Strategy, Joanna Kozar
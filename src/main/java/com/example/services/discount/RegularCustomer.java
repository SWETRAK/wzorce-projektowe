package com.example.services.discount;

//Tydzień 6, wzorzec Strategy, Joanna Kozar
//Implementacja promocji dla zwykłego klienta
public class RegularCustomer implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.95;
    }
}
//Koniec - Tydzień 6, wzorzec Strategy, Joanna Kozar
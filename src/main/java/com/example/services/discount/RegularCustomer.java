package com.example.services.discount;

//Tydzień 6, wzorzec Strategy, Joanna Kozar
//Implementacja promocji dla zwykłego klienta
public class RegularCustomer implements DiscountStrategy {

    private static final double REGULAR_DEFAULT_DISCOUNT = 0.95;

    public double applyDiscount(double price) {
        return price * REGULAR_DEFAULT_DISCOUNT;
    }
}
//Koniec - Tydzień 6, wzorzec Strategy, Joanna Kozar
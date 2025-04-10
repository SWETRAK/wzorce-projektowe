package com.example.services.discount;

//Tydzień 6, wzorzec Strategy, Joanna Kozar
//Implementacja promocji dla klienta VIP
public class VipCustomer implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
//Koniec - Tydzień 6, wzorzec Strategy, Joanna Kozar

package com.example.services.discount;

//Tydzień 6, wzorzec Strategy, Joanna Kozar
//Implementacja promocji dla klienta VIP
public class VipCustomer implements DiscountStrategy {

    private static final double VIP_DEFAULT_DISCOUNT = 0.80;

    public double applyDiscount(double price) {
        return price * VIP_DEFAULT_DISCOUNT;
    }
}
//Koniec - Tydzień 6, wzorzec Strategy, Joanna Kozar

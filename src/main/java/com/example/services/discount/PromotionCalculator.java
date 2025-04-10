package com.example.services.discount;

//Tydzień 6, wzorzec Strategy, Joanna Kozar
//Implementacja kalkulatora promocji dla klentów
public class PromotionCalculator {
    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double price) {
        return strategy.applyDiscount(price);
    }
}
//Koniec - Tydzień 6, wzorzec Strategy, Joanna Kozar

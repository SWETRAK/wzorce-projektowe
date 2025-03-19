package com.example.models.discount;

import java.util.ArrayList;
import java.util.List;

// Tydzień 2, Wzorzec Composite, Kamil Pietrak
// Klasa reprezentujac wiele zniżek, gdy pobieramy cenę po zniżce liczona jest średnia
public class MultipleDiscount implements PriceDiscount {

    private List<PriceDiscount> discounts = new ArrayList<>();

    public void addDiscount(PriceDiscount discount) {
        discounts.add(discount);
    }


    @Override
    public void applyDiscount(double price) {
        for (PriceDiscount discount : discounts) {
            discount.applyDiscount(price);
        }
    }

    @Override
    public double getSalePrice() {
        double salePrice = 0;
        int count = 0;

        for (PriceDiscount discount : discounts) {
            salePrice += discount.getSalePrice();
            count++;
        }

        return salePrice / count;
    }
}
// Konic, Tydzień 2, Wzorzec Composite, Kamil Pietrak

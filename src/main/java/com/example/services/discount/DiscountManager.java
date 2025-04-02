package com.example.services.discount;

import java.util.ArrayList;
import java.util.List;

// Tydzien 5, Wzorzec Command, Joanna Kozar
// Implementacja menagera rabatów (odbiorca komend)
public class DiscountManager {
    private final List<String> coupons = new ArrayList<>();

    public void addCoupon(String couponCode) {
        coupons.add(couponCode);
        System.out.println("Dodano kupon: " + couponCode);
    }

    public void activatePromotion() {
        System.out.println("Aktywowano promocję dla kuponów: " + coupons);
    }
}
// Tydzien 5, Wzorzec Command, Joanna Kozar
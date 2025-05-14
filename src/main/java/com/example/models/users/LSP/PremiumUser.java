package com.example.models.users.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa PremiumUser dziedzicząca po User
public class PremiumUser extends User {

    private static final double DEFAULT_PREMIUM_DISCOUNT = 0.15;

    public PremiumUser(String name) {
        super(name);
    }

    @Override
    public double getDiscount() {
        return DEFAULT_PREMIUM_DISCOUNT;
    }
}
// Koniec- Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar


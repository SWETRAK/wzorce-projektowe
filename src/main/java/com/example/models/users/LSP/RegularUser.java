package com.example.models.users.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa RegularUser dziedzicząca po User
public class RegularUser extends User {

    private static final double DEFAULT_REGULAR_DISCOUNT = 0.05;

    public RegularUser(String name) {
        super(name);
    }

    @Override
    public double getDiscount() {
        return DEFAULT_REGULAR_DISCOUNT;
    }
}
// Koniec- Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar

package com.example.models.users.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa PremiumUser dziedzicząca po User
public class PremiumUser extends User {
    public PremiumUser(String name) {
        super(name);
    }

    @Override
    public double getDiscount() {
        return 0.15;
    }
}
// Koniec- Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar


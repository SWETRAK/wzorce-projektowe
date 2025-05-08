package com.example.models.users.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa RegularUser dziedzicząca po User
public class RegularUser extends User {
    public RegularUser(String name) {
        super(name);
    }

    @Override
    public double getDiscount() {
        return 0.05;
    }
}
// Koniec- Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar

package com.example.models.users.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa bazowa dla użytkowników
public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract double getDiscount();
    public String getName() {
        return name;
    }
}
// Koniec- Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
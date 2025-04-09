package com.example.models.users.memento;

// Tydzień 6, Wzorzec Memento, Kamil Pietrak
// Klasa przechowująca stan klienta
public class ClientMemento {
    private final String email;
    public ClientMemento(String email) {
        this.email = email;
    }
    public String getState() {
        return email;
    }
}
// Koniec, Tydzień 6, Wzorzec Memento, Kamil Pietrak

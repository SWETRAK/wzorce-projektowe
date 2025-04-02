package com.example.services.cart;

// Tydzień 5, Wzorzec Command, Kamil Pietrak
// Klasa komendy dodającej książkę do koszyka
public interface CartCommand {
    void execute();
    void undo();
}
// Koniec, Tydzień 5, Wzorzec Command, Kamil Pietrak

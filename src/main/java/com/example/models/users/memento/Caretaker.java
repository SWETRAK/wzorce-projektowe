package com.example.models.users.memento;

import com.example.models.users.Client;

import java.util.Stack;

// Tydzień 6, Wzorzec Memento, Kamil Pietrak
// Klasa zarządzająca historią zmian klienta
public class Caretaker {
    private Stack<ClientMemento> history = new Stack<>();

    public void save(Client customer) {
        history.push(customer.save());
    }

    public void undo(Client customer) {
        if (!history.isEmpty()) {
            customer.restore(history.pop());
        }
    }
}
// Koniec, Tydzień 6, Wzorzec Memento, Kamil Pietrak
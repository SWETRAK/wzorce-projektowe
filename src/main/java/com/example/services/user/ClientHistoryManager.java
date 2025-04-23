package com.example.services.user;

import com.example.models.users.Client;
import com.example.models.users.memento.Caretaker;

// Tydzień 7, Zasada SRP, Maciej Potręć
// Klasa która odpowiada za zarządzanie historią zmian klienta
public class ClientHistoryManager {
    private final Caretaker caretaker;
    private final Client client;

    public ClientHistoryManager(Client client) {
        this.client = client;
        this.caretaker = new Caretaker();
    }

    public void save() {
        caretaker.save(client);
    }

    public void undo() {
        caretaker.undo(client);
    }

    public String getClientEmail() {
        return client.getEmail();
    }
}
// Koniec, Tydzień 7, Zasada SRP, Maciej Potręć

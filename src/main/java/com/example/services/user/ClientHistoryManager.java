package com.example.services.user;

import com.example.models.users.Client;
import com.example.models.users.memento.ClientCaretaker;

// Tydzień 7, Zasada SRP, Maciej Potręć
// Klasa która odpowiada za zarządzanie historią zmian klienta
public class ClientHistoryManager {
    private final ClientCaretaker clientCaretaker;
    private final Client client;

    public ClientHistoryManager(Client client) {
        this.client = client;
        this.clientCaretaker = new ClientCaretaker();
    }

    public void save() {
        clientCaretaker.save(client);
    }

    public void undo() {
        clientCaretaker.undo(client);
    }

    public String getClientEmail() {
        return client.getEmail();
    }
}
// Koniec, Tydzień 7, Zasada SRP, Maciej Potręć

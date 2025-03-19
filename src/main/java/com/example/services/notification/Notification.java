package com.example.services.notification;

// Tydzień 3, Wzorzec Bridge, Maciej Potręć
// Abstrakcja - bazowa klasa dla różnych typów powiadomień
public abstract class Notification {
    protected NotificationSender sender;

    public Notification(NotificationSender sender) {
        this.sender = sender;
    }

    public void setSender(NotificationSender sender) {
        this.sender = sender;
    }

    public abstract void send(String recipient);
}
// Koniec, Tydzień 3, Wzorzec Bridge, Maciej Potręć

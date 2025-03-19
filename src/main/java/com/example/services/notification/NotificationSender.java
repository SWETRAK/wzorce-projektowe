package com.example.services.notification;

// Tydzień 3, Wzorzec Bridge, Maciej Potręć
// Implementator - interfejs dla różnych sposobów wysyłania powiadomień
public interface NotificationSender {
    void sendNotification(String recipient, String subject, String content);
}
// Koniec, Tydzień 3, Wzorzec Bridge, Maciej Potręć

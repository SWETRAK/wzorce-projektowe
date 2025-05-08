package com.example.services.notification.dip;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// NotificationService jako interfejs wysokiego poziomu dla wysyłania powiadomień
public interface NotificationService {
    void sendNotification(String recipient, String message);
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć

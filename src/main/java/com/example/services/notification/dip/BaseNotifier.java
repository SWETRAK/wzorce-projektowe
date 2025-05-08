package com.example.services.notification.dip;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// BaseNotifier jako abstrakcja implementująca interfejs NotificationService
public abstract class BaseNotifier implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending notification to: " + recipient);
        System.out.println("Message: " + message);
    }
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć

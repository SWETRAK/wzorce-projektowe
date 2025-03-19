package com.example.services.notification;

// Tydzień 3, Wzorzec Bridge, Maciej Potręć
// Konkretny implementator - wysyłanie powiadomień przez e-mail
public class EmailNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String recipient, String subject, String content) {
        System.out.println("Sending EMAIL to: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Content: " + content);
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Maciej Potręć

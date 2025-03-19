package com.example.services.notification;

// Tydzień 3, Wzorzec Bridge, Maciej Potręć
// Konkretny implementator - wysyłanie powiadomień przez SMS
public class SMSNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String recipient, String subject, String content) {
        System.out.println("Sending SMS to: " + recipient);
        System.out.println("Message: " + subject + " - " + content);
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Maciej Potręć

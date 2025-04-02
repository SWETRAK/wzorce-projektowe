package com.example.services.notification;

//Tydzień 5, Wzorzec Mediator, Joanna Kozar
//Implementacja wysyłania powiadomień push
public class PushNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String recipient, String subject, String content) {
        System.out.println("Sending PUSH notification to device: " + recipient);
        System.out.println("Title: " + subject);
        System.out.println("Body: " + content);
    }
}
//Koniec - Tydzień 5, Wzorzec Mediator, Joanna Kozar
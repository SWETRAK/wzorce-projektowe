package com.example.services.notification;

import java.util.HashMap;
import java.util.Map;
//Tydzień 5, Wzorzec Mediator, Joanna Kozar
//Implementacja mediatora
public class NotificationCoordinator implements NotificationMediator {
    private final Map<String, NotificationSender> senders = new HashMap<>();

    @Override
    public void register(NotificationSender sender) {
        if (sender instanceof EmailNotificationSender) {
            senders.put("email", sender);
        } else if (sender instanceof SMSNotificationSender) {
            senders.put("sms", sender);
        } else if (sender instanceof PushNotificationSender) {
            senders.put("push", sender);
        }
    }

    @Override
    public void sendNotification(String type, String recipient, String subject, String content) {
        NotificationSender sender = senders.get(type.toLowerCase());
        if (sender != null) {
            sender.sendNotification(recipient, subject, content);
        } else {
            System.out.println("Nieznany typ powiadomienia: " + type);
        }
    }

    // Metoda pomocnicza do wysyłania powiadomień wieloma kanałami jednocześnie
    public void broadcastNotification(String[] types, String recipient, String subject, String content) {
        for (String type : types) {
            sendNotification(type, recipient, subject, content);
        }
    }
}
//Koniec - Tydzień 5, Wzorzec Mediator, Joanna Kozar
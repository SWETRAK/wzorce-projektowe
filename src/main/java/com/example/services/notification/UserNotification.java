package com.example.services.notification;

import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// System notyfikacji oparty na Notifier
public class UserNotification {
    private final Map<UserNotificationEnum, Notifier> notifiers = new HashMap<>();

    public UserNotification() {
        notifiers.put(UserNotificationEnum.EMAIL, new EmailNotifier());
        notifiers.put(UserNotificationEnum.SMS, new SMSNotifier());
    }

    public void notifyUser(UserNotificationEnum type, String user, String message) {
        Notifier notifier = notifiers.get(type);
        if (notifier != null) {
            notifier.send(user, message);
        } else {
            System.out.println("Brak notyfikatora dla typu: " + type);
        }
    }
}
//Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
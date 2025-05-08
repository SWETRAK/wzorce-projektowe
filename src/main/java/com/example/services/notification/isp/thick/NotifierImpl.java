package com.example.services.notification.isp.thick;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa implementująca interfejs Notifier
public class NotifierImpl implements Notifier {
    @Override
    public void notifyCustomer(String customerId, String message) {
        System.out.println("Notifying customer " + customerId + ": " + message);
    }

    @Override
    public void notifyAdmin(String adminId, String event) {
        System.out.println("Notifying admin " + adminId + ": " + event);
    }

    @Override
    public void notifyAccounting(String reportData) {
        System.out.println("Notifying accounting: " + reportData);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

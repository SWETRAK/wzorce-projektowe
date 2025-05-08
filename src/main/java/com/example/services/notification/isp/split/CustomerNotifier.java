package com.example.services.notification.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Interfejs CustomerNotifier odpowiedzialny za powiadamianie klientów
public interface CustomerNotifier {
    void sendNotificationToCustomer(String customerId, String message);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
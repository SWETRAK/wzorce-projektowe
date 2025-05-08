package com.example.services.notification.isp.thick;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Interfejs Notifier odpowiedzialny za powiadamianie różnych grup
public interface Notifier {
    void notifyCustomer(String customerId, String message);
    void notifyAdmin(String adminId, String event);
    void notifyAccounting(String reportData);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć


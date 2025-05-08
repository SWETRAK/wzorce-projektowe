package com.example.services.notification.isp.split;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa NotificationService implementująca interfejsy CustomerNotifier, AdminNotifier i AccountingNotifier
public class NotificationService implements CustomerNotifier, AdminNotifier, AccountingNotifier {
    @Override
    public void sendNotificationToCustomer(String customerId, String message) {
        System.out.println("Sending notification to customer " + customerId + ": " + message);
    }

    @Override
    public void sendReportToAccounting(String reportData) {
        System.out.println("Sending report to accounting: " + reportData);
    }

    @Override
    public void alertAdmin(String eventDetails) {
        System.out.println("Alerting admin: " + eventDetails);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

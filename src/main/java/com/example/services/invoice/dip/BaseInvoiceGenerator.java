package com.example.services.invoice.dip;

import com.example.services.notification.DIP.NotificationService;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// BaseInvoiceGenerator jako abstrakcja implementująca interfejs InvoiceGenerator
public abstract class BaseInvoiceGenerator implements InvoiceGenerator {
    protected NotificationService notificationService;

    public BaseInvoiceGenerator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void generateInvoice(String orderId, double amount) {
        System.out.println("Generating invoice for order ID: " + orderId + " with amount: " + amount);

        String message = "Your invoice for order ID: " + orderId + " has been generated with amount: " + amount;
        notificationService.sendNotification("user@gmail.com", message);
    }
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć

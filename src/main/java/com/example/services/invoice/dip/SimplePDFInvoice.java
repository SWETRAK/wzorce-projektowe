package com.example.services.invoice.dip;

import com.example.services.notification.DIP.NotificationService;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// SimplePDFInvoice jako konkretna implementacja generowania faktur PDF
public class SimplePDFInvoice extends BaseInvoiceGenerator
{
    public SimplePDFInvoice(NotificationService notificationService) {
        super(notificationService);
    }

    @Override
    public void generateInvoice(String orderId, double amount) {
        System.out.println("Generating a simple PDF invoice for order ID: " + orderId + " with amount: " + amount);

        String message = "Your simple PDF invoice for order ID: " + orderId + " has been generated with amount: " + amount;
        notificationService.sendNotification("user@gmail.com", message);
    }
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć

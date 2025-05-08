package com.example.services.invoice.isp.split;

import com.example.services.order.Order;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa InvoiceSenderImpl implementująca interfejs InvoiceSender
public class InvoiceSenderImpl implements InvoiceSender {
    @Override
    public void sendInvoice(Order order, String recipientEmail) {
        System.out.println("Sending invoice for order " + order.getOrderId() + " to " + recipientEmail);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

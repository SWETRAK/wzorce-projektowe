package com.example.services.invoice.isp.thick;

import com.example.services.order.Order;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa InvoiceServiceImpl implementująca interfejs InvoiceService
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public void generateInvoice(Order order) {
        System.out.println("Generating invoice for order ID: " + order.getOrderId());
    }

    @Override
    public void saveInvoice(Order order, String invoiceData) {
        System.out.println("Saving invoice for order ID: " + order.getOrderId());
    }

    @Override
    public void sendInvoice(Order order, String recipientEmail) {
        System.out.println("Sending invoice for order ID: " + order.getOrderId() + " to " + recipientEmail);
    }
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

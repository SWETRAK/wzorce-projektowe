package com.example.services.invoice.isp.split;

import com.example.services.order.Order;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Klasa InvoiceGeneratorImpl implementująca interfejsy InvoiceRenderer i InvoiceSaver
public class InvoiceGeneratorImpl implements InvoiceRenderer, InvoiceSaver {
    @Override
    public void generateInvoice(Order order) {
        System.out.println("Generating invoice for order: " + order);
    }

    @Override
    public void saveInvoice(Order order, String invoiceData) {
        System.out.println("Saving invoice for order: " + order + " with data: " + invoiceData);
    }
}

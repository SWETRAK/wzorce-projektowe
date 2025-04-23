package com.example.services.invoice;

import com.example.services.order.BasicOrder;

// Tydzień 7, Zasada OC, Maciej Potręć
// Klasa do eksportowania faktur w formacie PDF.
public class XMLInvoiceExporter implements InvoiceExporter {
    @Override
    public void exportInvoice(BasicOrder order, String filePath) {
        System.out.println("Exporting invoice to XML: " + order.getOrderId());
        System.out.println("File path: " + filePath);
    }
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

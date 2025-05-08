package com.example.services.invoice;

import com.example.services.order.BasicOrder;

// Tydzień 7, Zasada OC, Maciej Potręć
// Klasa do eksportowania faktur w formacie PDF.
// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// PDFInvoice implementuje fakturowanie w formacie PDF.
public class PDFInvoiceExporter extends AbstractInvoice implements InvoiceExporter {
    @Override
    public void exportInvoice(BasicOrder order, String filePath) {
        System.out.println("Exporting invoice to PDF: " + order.getOrderId());
        System.out.println("File path: " + filePath);
    }
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

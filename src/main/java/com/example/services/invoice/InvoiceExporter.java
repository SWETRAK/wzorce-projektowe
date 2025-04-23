package com.example.services.invoice;

import com.example.services.order.BasicOrder;

// Tydzień 7, Zasada OC, Maciej Potręć
// Interfejs do eksportowania faktur
public interface InvoiceExporter {
    void exportInvoice(BasicOrder order, String filePath);
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

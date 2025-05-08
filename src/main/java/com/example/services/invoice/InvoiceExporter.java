package com.example.services.invoice;

import com.example.services.order.BasicOrder;

// Tydzień 7, Zasada OC, Maciej Potręć
// Interfejs do eksportowania faktur
// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// InvoiceGenerator jako interfejs dla generowania faktur.
public interface InvoiceExporter {
    void exportInvoice(BasicOrder order, String filePath);
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

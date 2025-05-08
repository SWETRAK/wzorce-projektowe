package com.example.services.invoice.dip;

// Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć
// InvoiceGenerator jako interfejs wysokiego poziomu dla generowania faktur
public interface InvoiceGenerator {
    void generateInvoice(String orderId, double amount);
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Maciej Potręć

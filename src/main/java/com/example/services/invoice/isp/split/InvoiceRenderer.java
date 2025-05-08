package com.example.services.invoice.isp.split;

import com.example.services.order.Order;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Interfejs InvoiceRenderer odpowiedzialny za generowanie faktur
public interface InvoiceRenderer {
    void generateInvoice(Order order);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

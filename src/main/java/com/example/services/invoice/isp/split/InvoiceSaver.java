package com.example.services.invoice.isp.split;

import com.example.services.order.Order;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Interfejs InvoiceSaver odpowiedzialny za zapisywanie faktur
public interface InvoiceSaver {
    void saveInvoice(Order order, String invoiceData);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

package com.example.services.invoice.isp.split;

import com.example.services.order.Order;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// Interfejs InvoiceSender odpowiedzialny za wysyłanie faktur
public interface InvoiceSender {
    void sendInvoice(Order order, String recipientEmail);
}
// Koniec, Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć

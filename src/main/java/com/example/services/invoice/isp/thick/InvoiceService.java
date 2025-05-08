package com.example.services.invoice.isp.thick;

import com.example.services.order.Order;

// Tydzień 8, Zasada Segregacji Interfejsów, Maciej Potręć
// "Gruby" interfejs InvoiceService, który łączy w sobie wszystkie metody związane z fakturami
public interface InvoiceService {
    void generateInvoice(Order order);
    void saveInvoice(Order order, String invoiceData);
    void sendInvoice(Order order, String recipientEmail);
}
// Klasa InvoiceServiceImpl implementująca interfejs InvoiceService

package com.example.services.invoice;

import com.example.services.order.BasicOrder;

// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// AbstractInvoice jako ogólna abstrakcja procesu fakturowania.
public abstract class AbstractInvoice implements InvoiceExporter {
    public abstract void exportInvoice(BasicOrder order, String filePath);
}
//Koniec, Tydzień 8, Zasada Odwrócenia Zależności (DIP) 8
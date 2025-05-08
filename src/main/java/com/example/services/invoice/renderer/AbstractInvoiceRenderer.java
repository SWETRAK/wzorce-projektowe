package com.example.services.invoice.renderer;

// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// AbstractInvoiceRenderer jako abstrakcja implementująca wspólną logikę dla rendererów.
public abstract class AbstractInvoiceRenderer implements InvoiceRenderer {
    protected String generateHeader(Invoice invoice) {
        return "Invoice for: " + invoice.getCustomerName();
    }
    
    protected String generateFooter(Invoice invoice) {
        return "Total: " + invoice.getTotal() + " PLN";
    }
}
//Koniec, Tydzień 8, Zasada Odwrócenia Zależności (DIP) 2
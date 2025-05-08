package com.example.services.invoice.renderer;

// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// SimplePDFRenderer jako konkretna implementacja generująca faktury w PDF.
public class SimplePDFRenderer extends AbstractInvoiceRenderer {
    public String render(Invoice invoice) {
        return "PDF Document:\n" 
               + generateHeader(invoice) + "\n"
               + "Items: " + invoice.getItems() + "\n"
               + generateFooter(invoice);
    }
}
//Koniec, Tydzień 8, Zasada Odwrócenia Zależności (DIP) 3
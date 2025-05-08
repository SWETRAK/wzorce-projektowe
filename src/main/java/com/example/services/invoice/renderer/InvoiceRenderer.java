package com.example.services.invoice.renderer;

// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// InvoiceRenderer jako interfejs wysokiego poziomu dla renderowania faktur.
public interface InvoiceRenderer {
    String render(Invoice invoice);
}
//Koniec, Tydzień 8, Zasada Odwrócenia Zależności (DIP) 1
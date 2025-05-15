// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// OrderProcessor jako klasa wysokiego poziomu operująca wyłącznie na abstrakcjach.
package com.example.services;

import com.example.models.books.Book;
import com.example.services.books.BookRepository;
import com.example.services.delivery.DeliveryService;
import com.example.services.invoice.InvoiceExporter;
import com.example.services.order.BasicOrder;

public class OrderProcessor {
    private final BookRepository bookRepository;
    private final DeliveryService deliveryService;
    private final InvoiceExporter invoiceGenerator;

    // Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
    // Wstrzykiwanie zależności przez konstruktor (DIP)
    public OrderProcessor(BookRepository bookRepository,
                        DeliveryService deliveryService,
                        InvoiceExporter invoiceGenerator) {
        this.bookRepository = bookRepository;
        this.deliveryService = deliveryService;
        this.invoiceGenerator = invoiceGenerator;
    }

    // Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
    // Główna metoda przetwarzająca zamówienie (operuje tylko na abstrakcjach)
    public void processOrder(BasicOrder order, Book book) {
        // 1. Weryfikacja dostępności książki (abstrakcja BookRepository)
        Integer orderedBook = bookRepository.findStock(book.getTitle());
        if (orderedBook == null || orderedBook == 0) {
            System.out.println("Book not available: " + book.getTitle());
            return;
        }

        // 2. Generowanie faktury (abstrakcja InvoiceGenerator)
        invoiceGenerator.exportInvoice(order, book.getTitle());

        // 3. Realizacja dostawy (abstrakcja DeliveryService)
        deliveryService.deliverOrder(order.getOrderId());
    }
}
//Koniec, Tydzień 8, Zasada Odwrócenia Zależności (DIP) 9
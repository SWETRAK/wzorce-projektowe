package com.example.services.exporter;

import com.example.models.books.Book;

// Tydzień 6, Wzorzec Visitor, Kamil Pietrak
// Eksporter danych do formatu CSV
public class CSVExporter implements Exporter {
    public void visitBook(Book book) {
        System.out.println("Exporting to CSV: " + book.getTitle());
    }
}
// Koniec, Tydzień 6, Wzorzec Visitor, Kamil Pietrak
package com.example.services.exporter;

import com.example.models.books.Book;

// Tydzień 6, Wzorzec Visitor, Kamil Pietrak
// Eksporter danych do formatu CSV
//Tydzień 8, Zasada Podstawienia Liskov (LSP)
//Kamil Pietrak
//CSVExporter implementuje interfejs Exporter i pozwala na eksport danych do formatu CSV.
public class CSVExporter implements Exporter, CSVExport {
    public void visitBook(Book book) {
        System.out.println("Exporting to CSV: " + book.getTitle());
    }


    @Override
    public void exportCSV(String data) {
        System.out.println("Exporting to CSV: " + data);
    }
}
//Koniec, Tydzień 8, Zasada Podstawienia Liskov (LSP)
// Koniec, Tydzień 6, Wzorzec Visitor, Kamil Pietrak
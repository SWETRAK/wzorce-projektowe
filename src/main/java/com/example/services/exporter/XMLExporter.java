package com.example.services.exporter;

import com.example.models.books.Book;

// Tydzień 6, Wzorzec Visitor, Kamil Pietrak
// Eksporter danych do formatu XML
// Tydzień 8, Zasada Podstawienia Liskov (LSP)
// Kamil Pietrak
// PDFExporter implementuje interfejs Exporter i pozwala na eksport danych do formatu XML.
public class XMLExporter implements Exporter, XMLExport {
    public void visitBook(Book book) {
        System.out.println("Exporting to XML: " + book.getTitle());
    }

    @Override
    public void exportXML(String data) {
        System.out.println("Exporting to XML: " + data);
    }
}
// Koniec, Tydzień 8, Zasada Podstawienia Liskov (LSP)
// Koniec, Tydzień 6, Wzorzec Visitor, Kamil Pietrak
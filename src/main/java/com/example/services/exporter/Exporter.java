package com.example.services.exporter;


import com.example.models.books.Book;

// Tydzień 6, Wzorzec Visitor, Kamil Pietrak
// Interfejs definiujący operacje eksportu
//Tydzień 8, Zasada Podstawienia Liskov (LSP)
//Kamil Pietrak
//Exporter - interfejs i jego implementacje (CSV, PDF) umożliwiające wymienne użycie bez zmiany zachowania klienta.
public interface Exporter {
    void visitBook(Book book);
}
//Koniec, Tydzień 8, Zasada Podstawienia Liskov (LSP)
// Koniec, Tydzień 6, Wzorzec Visitor, Kamil Pietrak

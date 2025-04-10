package com.example.services.exporter;


import com.example.models.books.Book;

// Tydzień 6, Wzorzec Visitor, Kamil Pietrak
// Interfejs definiujący operacje eksportu
public interface Exporter {
    void visitBook(Book book);
}
// Koniec, Tydzień 6, Wzorzec Visitor, Kamil Pietrak
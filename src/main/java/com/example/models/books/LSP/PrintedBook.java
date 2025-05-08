package com.example.models.books.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa PrintedBook dziedzicząca po klasie Book
public class PrintedBook extends Book {
    public PrintedBook(String title) {
        super(title);
    }

    @Override
    public String getFormat() {
        return "Printed";
    }
}

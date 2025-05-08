package com.example.models.books.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa bazowa dla ksiązek
public abstract class Book {
    protected String title;

    public Book(String title) {
        this.title = title;
    }

    public abstract String getFormat();
    public String getTitle() {
        return title;
    }
}
//Koniec - Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
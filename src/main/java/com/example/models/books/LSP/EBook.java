package com.example.models.books.LSP;

// Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
// Klasa EBook dziedzicząca po klasie Book
public class EBook extends Book {
    public EBook(String title) {
        super(title);
    }

    @Override
    public String getFormat() {
        return "eBook";
    }
}
//Koniec - Tydzień 8 – Zasada Podstawienia Liskov (LSP) - Joanna Kozar
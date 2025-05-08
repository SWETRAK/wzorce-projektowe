package com.example.services.books.DIP;

// Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
// Klasa abstrakcyjna AbstractBookFetcher
public abstract class AbstractBookFetcher {
    protected BookSource source;

    public AbstractBookFetcher(BookSource source) {
        this.source = source;
    }

    public String fetch(String isbn) {
        return source.fetchBook(isbn);
    }
}
// Koniec - Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
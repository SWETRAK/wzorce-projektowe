package com.example.services.books.DIP;

// Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
// Klasa LocalDatabaseBookFetcher implementująca interfejs BookSource
public class LocalDatabaseBookFetcher implements BookSource {
    @Override
    public String fetchBook(String isbn) {
        return "Szczegóły książki dla ISBN: " + isbn;
    }
}
//Koniec - Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
package com.example.services.books;

// Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Klasa do wyszukiwania książek w bazie danych
public class DatabaseBookSearch implements BookSearch {
    @Override
    public String searchBook(String title) {
        return "Book found in database: " + title;
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Koniec, Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
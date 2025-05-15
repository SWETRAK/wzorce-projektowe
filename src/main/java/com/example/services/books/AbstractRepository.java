package com.example.services.books;

// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// AbstractRepository - abstrakcja implementacji repozytorium książek.

public abstract class AbstractRepository implements BookRepository {
    public abstract void save(String book, Integer quantity);
    public abstract Integer findStock(String title);

    public abstract String searchBook(String title);
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
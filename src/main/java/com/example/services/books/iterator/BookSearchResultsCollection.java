package com.example.services.books.iterator;

import com.example.models.books.Book;

// Tydzień 5, Wzorzec Iterator, Maciej Potręć
// Interfejs do kolekcji wyników wyszukiwania książek
public interface BookSearchResultsCollection {
    void addBook(Book book);
    void removeBook(Book book);
    BookSearchIterator createIterator();
    int size();
}
// Koniec, Tydzień 5, Wzorzec Iterator, Maciej Potręć

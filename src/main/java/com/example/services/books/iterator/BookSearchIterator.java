package com.example.services.books.iterator;

import com.example.models.books.Book;

// Tydzień 5, Wzorzec Iterator, Maciej Potręć
// Interfejs do iteracji po książkach
public interface BookSearchIterator {
    boolean hasNext();
    Book next();
    void reset();
}
// Koniec, Tydzień 5, Wzorzec Iterator, Maciej Potręć

package com.example.services.books.iterator;

import com.example.models.books.Book;

import java.util.List;

// Tydzień 5, Wzorzec Iterator, Maciej Potręć
// Klasa implementująca interfejs do iteracji po wynikach wyszukiwania książek
public class BookSearchResultIterator implements BookSearchIterator {
    private final List<Book> searchResults;
    private int currentPosition = 0;

    public BookSearchResultIterator(List<Book> searchResults) {
        this.searchResults = searchResults;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < searchResults.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            return null;
        }
        return searchResults.get(currentPosition++);
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
// Koniec, Tydzień 5, Wzorzec Iterator, Maciej Potręć

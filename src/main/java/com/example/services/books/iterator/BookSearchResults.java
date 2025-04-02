package com.example.services.books.iterator;

import com.example.models.books.Book;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Iterator, Maciej Potręć
// Klasa implementująca kolekcję wyników wyszukiwania książek
public class BookSearchResults implements BookSearchResultsCollection {
    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public BookSearchIterator createIterator() {
        return new BookSearchResultIterator(books);
    }

    @Override
    public int size() {
        return books.size();
    }
}
// Koniec, Tydzień 5, Wzorzec Iterator, Maciej Potręć

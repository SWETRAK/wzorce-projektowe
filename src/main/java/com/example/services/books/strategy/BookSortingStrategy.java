package com.example.services.books.strategy;

import com.example.models.books.Book;

import java.util.List;

// Tydzień 6, Wzorzec Strategy, Maciej Potręć
// Interfejs strategii sortowania książek.
public interface BookSortingStrategy {
    List<Book> sort(List<Book> books);
}
// Koniec, Tydzień 6, Wzorzec Strategy, Maciej Potręć

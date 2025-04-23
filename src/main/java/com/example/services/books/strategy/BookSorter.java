package com.example.services.books.strategy;

import com.example.models.books.Book;
import lombok.Setter;

import java.util.List;

// Tydzień 7, Zasada SRP, Maciej Potręć
// Klasa BookSorter odpowiedzialna za sortowanie książek w katalogu.
@Setter
public class BookSorter {
    private BookCatalog catalog;
    private BookSortingStrategy sortingStrategy;

    public List<Book> getSortedBooks() {
        return sortingStrategy.sort(catalog.getBooks());
    }
}
// Koniec, Tydzień 7, Zasada SRP, Maciej Potręć

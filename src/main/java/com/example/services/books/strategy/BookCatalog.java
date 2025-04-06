package com.example.services.books.strategy;

import com.example.models.books.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Tydzień 6, Wzorzec Strategy, Maciej Potręć
// Klasa reprezentująca katalog książek, która zawiera listę książek oraz strategię sortowania.
@Getter
@Setter
public class BookCatalog {
    private List<Book> books;
    private BookSortingStrategy sortingStrategy;

    public BookCatalog(List<Book> books) {
        this.books = books;
        this.sortingStrategy = new DateSortingStrategy();
    }

    public List<Book> getSortedBooks() {
        return sortingStrategy.sort(books);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy, Maciej Potręć

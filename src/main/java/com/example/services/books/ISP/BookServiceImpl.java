package com.example.services.books.ISP;

import com.example.models.books.Book;
import com.example.services.books.strategy.BookCatalog;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
// Klasa implementująca grupy interfejs BookService
public class BookServiceImpl implements BookService{
    private BookCatalog bookCatalog;

    @Override
    public void search(String keyword) {
        bookCatalog.getBooks().stream()
                .filter(book -> book.getTitle().contains(keyword))
                .forEach(System.out::println);
    }

    @Override
    public void filterByGenre(String genre) {
        bookCatalog.getBooks().stream()
                .filter(book -> book.getGenre().equals(genre))
                .forEach(System.out::println);
    }

    @Override
    public void addBook(Book book) {
        if (bookCatalog.getBooks().stream().anyMatch(b -> b.getISBNIdentifier().equals(book.getISBNIdentifier()))) {
            throw new IllegalArgumentException("Book with this ISBN Identifier already exists");
        }

        bookCatalog.addBook(book);
    }

    @Override
    public void editBook(Book book) {
        bookCatalog.getBooks().stream()
                .filter(b -> b.getISBNIdentifier().equals(book.getISBNIdentifier()))
                .findFirst()
                .ifPresent(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthors(book.getAuthors());
                    b.setGenre(book.getGenre());
                    b.setPublisher(book.getPublisher());
                    b.setPublishedDate(book.getPublishedDate());
                    b.setPages(book.getPages());
                    b.setDescription(book.getDescription());
                    b.setISBNIdentifier(book.getISBNIdentifier());
                });
    }

    @Override
    public void deleteBook(String ISBNIdentifier) {
        if (ISBNIdentifier == null || ISBNIdentifier.isEmpty()) {
            throw new IllegalArgumentException("ISBN Identifier cannot be null or empty");
        }
        if (bookCatalog.getBooks().stream().noneMatch(book -> book.getISBNIdentifier().equals(ISBNIdentifier))) {
            throw new IllegalArgumentException("Book with this ISBN Identifier does not exist");
        }
        bookCatalog.getBooks().removeIf(book -> book.getISBNIdentifier().equals(ISBNIdentifier));
    }
}
// Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar

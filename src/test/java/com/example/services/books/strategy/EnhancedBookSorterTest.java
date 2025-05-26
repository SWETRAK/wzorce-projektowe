package com.example.services.books.strategy;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.books.BookFormat;
import com.example.models.books.Ebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Tydzień 12, Testy jednostkowe, Maciej Potręć
// Klasa testowa dla EnhancedBookSorter, która sprawdza różne strategie sortowania książek
class EnhancedBookSorterTest {
    private EnhancedBookSorter bookSorter;
    private BookCatalog catalog;
    private List<Book> books;
    private Book book1, book2, book3;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();

        BookFormat format = new Ebook();
        Author author1 = new Author("John", "Smith");
        Author author2 = new Author("Alice", "Brown");
        Author author3 = new Author("Bob", "Johnson");

        Date date1 = new Date(120, 1, 1); // 2020
        Date date2 = new Date(121, 2, 1); // 2021
        Date date3 = new Date(119, 3, 1); // 2019

        book1 = new Book.Builder("Python Programming", "Description 1",
                List.of(author1), date1, format)
                .genre("Programming")
                .publisher("Tech Books")
                .pages(300)
                .build();

        book2 = new Book.Builder("Java Fundamentals", "Description 2",
                List.of(author2), date2, format)
                .genre("Education")
                .publisher("Academic Press")
                .pages(450)
                .build();

        book3 = new Book.Builder("Design Patterns", "Description 3",
                List.of(author3), date3, format)
                .genre("Computer Science")
                .publisher("Code Publishing")
                .pages(200)
                .build();

        books.add(book1);
        books.add(book2);
        books.add(book3);

        catalog = new BookCatalog(books);
        bookSorter = new EnhancedBookSorter(catalog);
    }

    @Test
    void testTitleSorting() {
        List<Book> sortedBooks = bookSorter.getSortedBooks(SortStrategyType.TITLE);

        assertEquals(3, sortedBooks.size());
        assertEquals("Design Patterns", sortedBooks.get(0).getTitle());
        assertEquals("Java Fundamentals", sortedBooks.get(1).getTitle());
        assertEquals("Python Programming", sortedBooks.get(2).getTitle());
    }

    @Test
    void testAuthorSorting() {
        List<Book> sortedBooks = bookSorter.getSortedBooks(SortStrategyType.AUTHOR);

        assertEquals(3, sortedBooks.size());
        assertEquals("Brown", sortedBooks.get(0).getAuthors().get(0).lastName());
        assertEquals("Johnson", sortedBooks.get(1).getAuthors().get(0).lastName());
        assertEquals("Smith", sortedBooks.get(2).getAuthors().get(0).lastName());
    }

    @Test
    void testDateSorting() {
        List<Book> sortedBooks = bookSorter.getSortedBooks(SortStrategyType.DATE);

        assertEquals(3, sortedBooks.size());
        // Date sorting is reversed (newest first)
        assertEquals(book2.getTitle(), sortedBooks.get(0).getTitle()); // 2021
        assertEquals(book1.getTitle(), sortedBooks.get(1).getTitle()); // 2020
        assertEquals(book3.getTitle(), sortedBooks.get(2).getTitle()); // 2019
    }

    @Test
    void testEmptyCatalog() {
        BookCatalog emptyCatalog = new BookCatalog(new ArrayList<>());
        EnhancedBookSorter emptySorter = new EnhancedBookSorter(emptyCatalog);

        List<Book> sortedBooks = emptySorter.getSortedBooks(SortStrategyType.TITLE);
        assertTrue(sortedBooks.isEmpty());
    }

    @Test
    void testUnsupportedStrategy() {
        SortStrategyType unsupportedType = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookSorter.getSortedBooks(unsupportedType);
        });

        assertTrue(exception.getMessage().contains("Unsupported sorting strategy"));
    }
}
// Koniec, Tydzień 12, Testy jednostkowe, Maciej Potręć
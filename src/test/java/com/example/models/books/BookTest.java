package com.example.models.books;

import com.example.models.Author;
import com.example.models.bookhistory.BookMemento;
import com.example.services.exporter.Exporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

// Tydzień 12, Testy jednostkowe, Maciej Potręć
// Klasa testowa dla Book, która sprawdza różne funkcjonalności książki
class BookTest {
    private Book book;
    private Author author;
    private Date publishDate;
    private BookFormat bookFormat;

    @BeforeEach
    void setUp() {
        author = new Author("John", "Doe");
        publishDate = new Date();
        bookFormat = new Ebook();
        book = new Book.Builder("Test Title", "Test Description",
                Collections.singletonList(author), publishDate, bookFormat)
                .genre("Fiction")
                .publisher("Test Publisher")
                .pages(200)
                .ISBNIdentifier("1234567890")
                .build();
    }

    @Test
    void testBuilderPattern() {
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Description", book.getDescription());
        assertEquals(Collections.singletonList(author), book.getAuthors());
        assertEquals(publishDate, book.getPublishedDate());

        assertEquals("Fiction", book.getGenre());
        assertEquals("Test Publisher", book.getPublisher());
        assertEquals(200, book.getPages());
        assertEquals("1234567890", book.getISBNIdentifier());
    }

    @Test
    void testBookWithDifferentProperties() {
        Book anotherBook = new Book.Builder("Different Title", "Different Description",
                Collections.singletonList(author), publishDate, bookFormat)
                .genre("Non-Fiction")
                .publisher("Another Publisher")
                .pages(300)
                .ISBNIdentifier("0987654321")
                .build();

        assertNotEquals(book.getTitle(), anotherBook.getTitle());
        assertNotEquals(book.getDescription(), anotherBook.getDescription());
        assertNotEquals(book.getGenre(), anotherBook.getGenre());
        assertNotEquals(book.getPublisher(), anotherBook.getPublisher());
        assertNotEquals(book.getPages(), anotherBook.getPages());
        assertNotEquals(book.getISBNIdentifier(), anotherBook.getISBNIdentifier());
    }

    @Test
    void testMementoPattern() {
        BookMemento memento = book.save();

        book.setTitle("Changed Title");
        book.setDescription("Changed Description");
        assertEquals("Changed Title", book.getTitle());

        book.restore(memento);

        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Description", book.getDescription());
    }

    @Test
    void testShowBookInfo() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            book.showBookInfo();
            String output = outputStream.toString();
            assertTrue(output.contains("Book: Test Title - Test Description"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testDisplayBookTitle() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            book.displayBookTitle();
            String output = outputStream.toString();
            assertTrue(output.contains("BookTitle: Test Title"));
        } finally {
            System.setOut(originalOut);
        }
    }
}
// Koniec, Tydzień 12, Testy jednostkowe, Maciej Potręć
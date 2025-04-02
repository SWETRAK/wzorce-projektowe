package com.example.services.books.iterator;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.books.PhysicalBook;
import com.example.services.books.BookSearchEngine;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Tydzień 5, Wzorzec Iterator, Maciej Potręć
// Klasa rozszerzająca funkcjonalność wyszukiwania książek
public class EnhancedBookSearchEngine extends BookSearchEngine {

    private final Map<String, BookSearchResults> searchResultsCache = new HashMap<>();

    public BookSearchResults findBooksByTitle(String title) {
        if (searchResultsCache.containsKey(title)) {
            return searchResultsCache.get(title);
        }

        BookSearchResults results = new BookSearchResults();

        String searchResult = super.searchBook(title);

        // Testowo zwracam 3 wyniki aby zawsze coś tam było
        if (searchResult != null && !searchResult.isEmpty()) {
            mockPopulateResults(results, title);
        }

        searchResultsCache.put(title, results);
        return results;
    }

    private void mockPopulateResults(BookSearchResults results, String title) {
        Book mockBook1 = createMockBook(title + " - Part 1");
        Book mockBook2 = createMockBook(title + " - Part 2");
        Book mockBook3 = createMockBook(title + " - Part 3");

        results.addBook(mockBook1);
        results.addBook(mockBook2);
        results.addBook(mockBook3);
    }

    private Book createMockBook(String title) {
        return new Book.Builder(
                title,
                "desc",
                Collections.singletonList(new Author("Imie", "Nazwisko")),
                new Date(),
                new PhysicalBook()
        ).build();
    }
}
// Koniec, Tydzień 5, Wzorzec Iterator, Maciej Potręć

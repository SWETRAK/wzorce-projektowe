package com.example.services.books.strategy;

import com.example.models.books.Book;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Tydzień 7, Zasada OC, Maciej Potręć
// Klasa odpowiedzialna za sortowanie książek według różnych kryteriów.
public class EnhancedBookSorter {
    @Setter
    private BookCatalog catalog;
    private final Map<SortStrategyType, BookSortingStrategy> strategies = new HashMap<>();

    public EnhancedBookSorter(BookCatalog catalog) {
        this.catalog = catalog;
        initializeStrategies();
    }

    private void initializeStrategies() {
        strategies.put(SortStrategyType.TITLE, new TitleSortingStrategy());
        strategies.put(SortStrategyType.AUTHOR, new AuthorSortingStrategy());
        strategies.put(SortStrategyType.DATE, new DateSortingStrategy());
        strategies.put(SortStrategyType.GENRE, new GenreSortingStrategy());
        strategies.put(SortStrategyType.PAGES, new PageCountSortingStrategy());
        strategies.put(SortStrategyType.PUBLISHER, new PublisherSortingStrategy());
    }

    public List<Book> getSortedBooks(SortStrategyType strategyType) {
        BookSortingStrategy strategy = strategies.get(strategyType);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported sorting strategy: " + strategyType);
        }
        return strategy.sort(catalog.getBooks());
    }
}
// Koniec, Tydzień 7, Zasada OC, Maciej Potręć

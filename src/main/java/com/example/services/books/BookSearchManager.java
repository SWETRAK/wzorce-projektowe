package com.example.services.books;

import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Menedżer obsługujący różne strategie wyszukiwania książek
public class BookSearchManager {

    private final Map<BookSearchType, BookSearch> strategies = new HashMap<>();

    public BookSearchManager(
            DatabaseBookSearch dbSearch,
            WarehauseBookSearch warehouseSearch) {
        strategies.put(BookSearchType.DATABASE, dbSearch);
        strategies.put(BookSearchType.WAREHOUSE, warehouseSearch);
    }

    public void search(BookSearchType type, String title) {
        BookSearch strategy = strategies.get(type);
        if (strategy != null) {
            String result = strategy.searchBook(title);
            System.out.println(result);
        } else {
            System.out.println("Unknown search type: " + type.toString());
        }
    }
}
// Koniec, Tydzień 7, Zasada OCP, Kamil Pietrak
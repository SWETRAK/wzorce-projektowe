package com.example.services.books;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Proxy, które buforuje wyniki wyszukiwania, aby uniknąć zbędnych zapytań do bazy danych.
public class BookSearchEngine implements BookSearch {

    private final BookSearch databaseBookSearch;

    private final BookSearch warehauseBookSearch;

    private final Map<String, String> cache = new HashMap<>();

    public BookSearchEngine(BookSearch warehouseBookRepository, BookSearch databasesBookSearch) {
        warehauseBookSearch = warehouseBookRepository;
        this.databaseBookSearch = databasesBookSearch;
    }

    @Override
    public String searchBook(String title) {
        if (cache.containsKey(title)) {
            return "(Cached) " + cache.get(title);
        } else {
            String result = databaseBookSearch.searchBook(title);

            if (result == null) {
                result = warehauseBookSearch.searchBook(title);
            }

            cache.put(title, result);
            return result;
        }
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy, Kamil Pietrak

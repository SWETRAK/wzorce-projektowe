package com.example.services.books;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Proxy, które buforuje wyniki wyszukiwania, aby uniknąć zbędnych zapytań do bazy danych.
public class BookSearchEngine implements BookSearch {

    private DatabaseBookSearch realBookSearch = new DatabaseBookSearch();

    private WarehauseBookSearch realWarehauseBookSearch = new WarehauseBookSearch();

    private Map<String, String> cache = new HashMap<>();

    @Override
    public String searchBook(String title) {
        if (cache.containsKey(title)) {
            return "(Cached) " + cache.get(title);
        } else {
            String result = realBookSearch.searchBook(title);

            if (result == null) {
                result = realWarehauseBookSearch.searchBook(title);
            }

            cache.put(title, result);
            return result;
        }
    }
}

// Koniec, Tydzień 4, Wzorzec Proxy, Kamil Pietrak

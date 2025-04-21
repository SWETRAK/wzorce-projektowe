package com.example.services.books;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Proxy, które buforuje wyniki wyszukiwania, aby uniknąć zbędnych zapytań do bazy danych.
public class BookSearchEngine implements BookSearch {

    private final DatabaseBookSearch realBookSearch = new DatabaseBookSearch();

    private final WarehauseBookSearch realWarehauseBookSearch;

    private final Map<String, String> cache = new HashMap<>();

    public BookSearchEngine(WarehouseRepository warehouseRepository) {
        realWarehauseBookSearch = new WarehauseBookSearch(warehouseRepository);
    }

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

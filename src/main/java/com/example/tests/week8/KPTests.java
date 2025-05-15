package com.example.tests.week8;

import com.example.services.books.AbstractRepository;
import com.example.services.books.BookSearch;
import com.example.services.books.BookSearchEngine;
import com.example.services.books.DatabaseBookSearch;
import com.example.services.books.WarehauseBookSearch;
import com.example.services.books.WarehouseBookRepository;

public class KPTests {

    public static void main(String[] args) {

        AbstractRepository warehouseBookRepository = new WarehouseBookRepository();

        BookSearch databaseBookSearch = new DatabaseBookSearch();
        BookSearch warehouseBookSearch = new WarehauseBookSearch(warehouseBookRepository);

        BookSearch bookSearchEngine = new BookSearchEngine(warehouseBookSearch, databaseBookSearch);

        bookSearchEngine.searchBook("Clean Code");
    }
}

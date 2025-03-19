package com.example.services.books;

// Tydzień 3, Wzorzec Adapter, Maciej Potręć
// Interfejs systemu księgarni dla dostawców książek
public interface BookProvider {
    void findBooks(String query);
    void getBookInfo(String isbn);
    void orderBook(String isbn, int quantity);
}
// Koniec, Tydzień 3, Wzorzec Adapter, Maciej Potręć

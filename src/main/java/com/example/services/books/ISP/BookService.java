package com.example.services.books.ISP;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Gruby interfejs BookService
public interface BookService {
    void search(String keyword);
    void filterByCategory(String category);
    void addBook(String title);
    void editBook(String id);
    void deleteBook(String id);
}
//Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
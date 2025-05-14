package com.example.services.books.ISP;

import com.example.models.books.Book;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Gruby interfejs BookService
public interface BookService {
    void search(String keyword);
    void filterByGenre(String genre);
    void addBook(Book book);
    void editBook(Book book);
    void deleteBook(String ISBNIdentifier);
}
//Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
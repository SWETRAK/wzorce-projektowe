package com.example.services.books.ISP;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Podzielony interfejs BookEditor
public interface BookEditor {
    void addBook(String title);
    void editBook(String id);
    void deleteBook(String id);
}
//Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
package com.example.services.books.ISP;

// Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
//Podzielony interfejs BookSearch
public interface BookSearch {
    void search(String keyword);
    void filterByGenre(String genre);
}
//Koniec - Tydzień 8 – Zasada Segregacji Interfejsów (ISP) - Joanna Kozar
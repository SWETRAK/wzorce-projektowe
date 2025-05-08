package com.example.services.books;

// Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Interfejs do wyszukiwania książek.
//Tydzień 8, Zasada Podstawienia Liskov, Kamil Pietrak
//Interfejs BookSearch i jego implementacje umożliwiają różne metody wyszukiwania (magazyn, baza).
public interface BookSearch {
    String searchBook(String title);
}
//Koniec, Tydzień 8, Zasada Podstawienia Liskov, Kamil Pietrak
// Koniec, Tydzień 4, Wzorzec Proxy, Kamil Pietrak
package com.example.services.books;

// Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
// BookRepository jako interfejs zależny od abstrakcji danych.
public interface BookRepository {
    void save(String book, Integer quantity);
    Integer find(String title) ;
}
// Koniec, Tydzień 8, Zasada Odwrócenia Zależności, Kamil Pietrak
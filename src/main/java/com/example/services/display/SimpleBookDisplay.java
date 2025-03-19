package com.example.services.display;

import com.example.models.books.Book;

// Tydzień 2, Wzorzec Decorator, Kamil Pietrak
// Podstawowy dekorator wyświetlając tylko podstawowe informacje
public class SimpleBookDisplay implements BookDisplay {

    private final Book book;

    public SimpleBookDisplay(Book book) {
        this.book = book;
    }

    @Override
    public void showBookInfo() {
        System.out.print("Default Book Info: " + book.getTitle() + " " + book.getGenre());
    }
}
// Kociec, Tydzień 2, Wzorzec Decorator, Kamil Pietrak
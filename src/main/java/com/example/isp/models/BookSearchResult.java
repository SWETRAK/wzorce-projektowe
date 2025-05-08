package com.example.isp.models;

import com.example.models.books.Book;

// Tydzień 8, Model danych, Kamil Pietrak
// Klasa BookSearchResult reprezentująca wynik wyszukiwania.
public class BookSearchResult {
    private final Book book;
    private final int availableCopies;
    private final Location location;

    public BookSearchResult(Book book, int copies, Location loc) {
        this.book = book;
        this.availableCopies = copies;
        this.location = loc;
    }

    // Gettery
    public Book getBook() { return book; }
    public int getAvailableCopies() { return availableCopies; }
    public Location getLocation() { return location; }
}
//Koniec, Tydzień 8, Model danych (BookSearchResult)
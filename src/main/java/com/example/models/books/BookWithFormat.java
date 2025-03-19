package com.example.models.books;

// Tydzień 3, Wzorzec Bridge, Kamil Pietrak
// Klasa abstrakcyjna zawierająca format książki
public abstract class BookWithFormat {

    protected BookFormat bookFormat;

    public BookWithFormat(BookFormat bookFormat) {
        this.bookFormat = bookFormat;
    }

    abstract void showBookInfo();
}
// Koniec, Tydzień 3, Wzorzec Bridge, Kamil Pietrak
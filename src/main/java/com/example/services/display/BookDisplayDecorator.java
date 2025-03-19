package com.example.services.display;

// Tydzień 3, Wzorzec Decorator, Kamil Pietrak
// Klasa abstrakcyjna dekoratora, która zawiera pole przechowujące dekoratora
public abstract class BookDisplayDecorator implements BookDisplay{

    protected BookDisplay bookDisplay;

    public BookDisplayDecorator(BookDisplay bookDisplay) {
        this.bookDisplay = bookDisplay;
    }

    @Override
    public void showBookInfo() {
        bookDisplay.showBookInfo();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Kamil Pietrak

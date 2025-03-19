package com.example.services.display;

// Tydzień 2, Wzorzec Decorator, Kamil Pietrak
// Klasa dekoratora dodająca info o fakcie że książka jest w twardej okładce
public class HardCoverBookDisplayDecorator extends BookDisplayDecorator {

    public HardCoverBookDisplayDecorator(BookDisplay bookDisplay) {
        super(bookDisplay);
    }

    @Override
    public void showBookInfo() {
        bookDisplay.showBookInfo();
        System.out.println(" - Hard Cover Book");
    }
}
// Koniec, Tydzień 2, Wzorzec Decorator, Kamil Pietrak
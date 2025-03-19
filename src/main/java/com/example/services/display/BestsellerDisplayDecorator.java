package com.example.services.display;

// Tydzień 2, Wzorzec Decorator, Kamil Pietrak
// Klasa dekoratora dodająca info o fakcie że książka jest bestselerem
public class BestsellerDisplayDecorator extends BookDisplayDecorator {

    public BestsellerDisplayDecorator(BookDisplay bookDisplay) {
        super(bookDisplay);
    }

    @Override
    public void showBookInfo() {
        System.out.print("BestSeller: ");
        bookDisplay.showBookInfo();
    }
}
// Koniec, Tydzień 2, Wzorzec Decorator, Kamil Pietrak
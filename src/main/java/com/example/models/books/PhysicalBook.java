package com.example.models.books;


// Tydzień 3, Wzorzec Bridge, Kamil Pietrak
// Klasa reprezentująca Physicalbook jako format książki
public class PhysicalBook implements BookFormat {

    @Override
    public void showBookFormat() {
        System.out.println("This book is a Physical book");
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Kamil Pietrak
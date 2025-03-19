package com.example.models.books;

// Tydzień 3, Wzorzec Bridge, Kamil Pietrak
// Klasa reprezentująca fizyczną książkę jako format książki
public class PhysicalBook implements BookFormat {
    @Override
    public void showBookFormat() {
        System.out.println("This book is a PhysicalBook");
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Kamil Pietrak

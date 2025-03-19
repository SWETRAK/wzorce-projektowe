package com.example.models.books;

// Tydzień 2, Wzorzec Bridge, Kamil Pietrak
// Klasa reprezentująca AudioBook jako format książki
public class AudioBook implements BookFormat{

    @Override
    public void showBookFormat() {
        System.out.println("This book is a Ebook");
    }
}
// Koniec, Tydzień 2, Wzorzec Bridge, Kamil Pietrak
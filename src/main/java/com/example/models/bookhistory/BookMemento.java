package com.example.models.bookhistory;

//Tydzień 6, wzorzec Memento, Joanna Kozar
//Implementacja klasy do historii edycji książki przez administratora
public class BookMemento {
    private final String title;
    private final String description;

    public BookMemento(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
//Koniec - Tydzień 6, wzorzec Memento, Joanna Kozar
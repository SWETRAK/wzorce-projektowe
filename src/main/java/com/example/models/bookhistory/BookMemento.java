package com.example.models.bookhistory;

import lombok.Getter;

//Tydzień 6, wzorzec Memento, Joanna Kozar
//Implementacja klasy do historii edycji książki przez administratora
@Getter
public class BookMemento {
    private final String title;
    private final String description;

    public BookMemento(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
//Koniec - Tydzień 6, wzorzec Memento, Joanna Kozar
package com.example.models.papers;

import com.example.models.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class Paper {

    protected String title;
    protected String description;
    protected Date publishedDate;
    protected String ISSNIdentifier;
    protected int paperId;
    protected int pages;
    protected List<Author> authors;

    // Tydzień 2, Wzorzec prototype, Kamil Pietrak
    // Abstrakcyjna metoda copy służąca do głębokiego kopiowania obiektów
    abstract Paper copy();
    // Koniec, Tydzień 2, Wzorzec prototype, Kamil Pietrak

    // Tydzień 2, Wzorzec factory, Kamil Pietrak
    // Abstrakcyjna metoda build służąca do budowania obiektu podczas procesu zachodzącego w fabryce, np. pobieranie informacji z bazy danych itp
    abstract void build();
    // Koniec, Tydzień 2, Wzorzec factory, Kamil Pietrak
}

package com.example.models.papers;

import com.example.models.Author;

import java.util.Date;
import java.util.List;

public class Newspaper extends Paper {

    public Newspaper(String ISDNIdentifier) {
        this.ISSNIdentifier = ISDNIdentifier;
    }

    public Newspaper(
            String title,
            String description,
            Date publishedDate,
            int paperId,
            int pages,
            String ISDNIdentifier,
            List<Author> authors) {
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
        this.paperId = paperId;
        this.pages = pages;
        this.ISSNIdentifier = ISDNIdentifier;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + this.getTitle() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", publishedDate=" + this.getPublishedDate() +
                ", ISDNIdentifier='" + this.getISSNIdentifier() + '\'' +
                ", paperId=" + this.getPaperId() +
                ", pages=" + this.getPages() +
                '}';
    }

    // Tydzień 1, Wzorzec prototype, Kamil Pietrak
    // Nadpisanie, implementacja abstrakcyjnej metoda copy służąca do głębokiego kopiowania obiektu Newspaper
    @Override
    public Paper copy() {
        return new Newspaper(
                this.getTitle(),
                this.getDescription(),
                (Date) this.getPublishedDate().clone(),
                this.getPaperId(),
                this.getPages(),
                this.getISSNIdentifier(),
                this.getAuthors());
    }
    // Koniec, Tydzień 1, Wzorzec factory, Kamil Pietrak

    // Tydzień 1, Wzorzec factory, Kamil Pietrak
    // Nadpisanie, implementacja metoda build służąca do budowania obiektu podczas procesu zachodzącego w fabryce, np. pobieranie informacji z bazy danych itp
    @Override
    public void build() {
        System.out.println("Getting newspaper data from ISDN catalogue");
    }
    // Koniec, Tydzień 1, Wzorzec factory, Kamil Pietrak
}

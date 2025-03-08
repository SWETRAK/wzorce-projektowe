package com.example.models.papers;

import java.util.Date;

public class Newspaper extends Paper {

    public Newspaper(String ISDNIdentifier) {
        this.ISDNIdentifier = ISDNIdentifier;
    }

    public Newspaper(String title, String description, Date publishedDate, int paperId, int pages, String ISDNIdentifier) {
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
        this.paperId = paperId;
        this.pages = pages;
        this.ISDNIdentifier = ISDNIdentifier;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + this.getTitle() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", publishedDate=" + this.getPublishedDate() +
                ", ISDNIdentifier='" + this.getISDNIdentifier() + '\'' +
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
                this.getISDNIdentifier());
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

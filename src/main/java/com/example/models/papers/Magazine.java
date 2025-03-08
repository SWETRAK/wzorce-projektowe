package com.example.models.papers;

import com.example.models.Author;

import java.util.Date;
import java.util.List;

public class Magazine extends Paper {

    private int articleNumber;

    public Magazine(String ISDNIdentifier) {
        this.ISSNIdentifier = ISDNIdentifier;
    }

    public Magazine(
            String title,
            String description,
            Date publishedDate,
            int paperId,
            int pages,
            int articleNumber,
            String ISSNIdentifier,
            List<Author> authors) {
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
        this.paperId = paperId;
        this.pages = pages;
        this.articleNumber = articleNumber;
        this.ISSNIdentifier = ISSNIdentifier;
        this.authors = authors;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + this.getTitle() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", publishedDate=" + this.getPublishedDate().toString() +
                ", ISDNIdentifier='" + this.getISSNIdentifier() + '\'' +
                ", paperId=" + this.getPaperId() +
                ", pages=" + this.getPages() +
                ", articleNumber=" + this.getArticleNumber() +
                '}';
    }

    // Tydzień 1, Wzorzec prototype, Kamil Pietrak
    // Nadpisanie, implementacja abstrakcyjnej metoda copy służąca do głębokiego kopiowania obiektu Magazine
    @Override
    public Paper copy() {
        return new Magazine(
                this.getTitle(),
                this.getDescription(),
                (Date) this.getPublishedDate().clone(),
                this.getPaperId(),
                this.getPages(),
                this.getArticleNumber(),
                this.getISSNIdentifier(),
                this.getAuthors());
    }
    // Koniec, Tydzień 1, Wzorzec factory, Kamil Pietrak

    // Tydzień 1, Wzorzec factory, Kamil Pietrak
    // Nadpisanie, implementacja metoda build służąca do budowania obiektu podczas procesu zachodzącego w fabryce, np. pobieranie informacji z bazy danych itp
    @Override
    public void build() {
        System.out.println("Getting magazine data from ISDN catalogue");
    }
    // Koniec, Tydzień 1, Wzorzec factory, Kamil Pietrak
}

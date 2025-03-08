package com.example.models.papers;

import com.example.models.Author;

import java.util.Date;
import java.util.List;

public abstract class Paper {

    protected String title;
    protected String description;
    protected Date publishedDate;
    protected String ISSNIdentifier;
    protected int paperId;
    protected int pages;
    protected List<Author> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getISSNIdentifier() {
        return ISSNIdentifier;
    }

    public void setISSNIdentifier(String ISSNIdentifier) {
        this.ISSNIdentifier = ISSNIdentifier;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    // Tydzień 1, Wzorzec prototype, Kamil Pietrak
    // Abstrakcyjna metoda copy służąca do głębokiego kopiowania obiektów
    abstract Paper copy();
    // Koniec, Tydzień 1, Wzorzec prototype, Kamil Pietrak

    // Tydzień 1, Wzorzec factory, Kamil Pietrak
    // Abstrakcyjna metoda build służąca do budowania obiektu podczas procesu zachodzącego w fabryce, np. pobieranie informacji z bazy danych itp
    abstract void build();
    // Koniec, Tydzień 1, Wzorzec factory, Kamil Pietrak
}

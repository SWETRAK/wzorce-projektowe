package com.example.models.books;

import com.example.models.Author;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Book extends BookWithFormat implements BookComponent {

    private final String title;
    private final String description;
    private final List<Author> authors;
    private final Date publishedDate;
    private final String genre;
    private final String publisher;
    private final int pages;
    private final String ISBNIdentifier;

    public Book(String title, String description, List<Author> authors, Date publishedDate, String genre, String publisher, int pages, String ISBNIdentifier, BookFormat bookFormat) {
        super(bookFormat);
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.publisher = publisher;
        this.pages = pages;
        this.ISBNIdentifier = ISBNIdentifier;
    }

    @Override
    public void showBookInfo() {
        System.out.println("Book: " + title + " - " + description );
        bookFormat.showBookFormat();
    }


    //Asia
    @Override
    public void displayBookTitle() {
        System.out.println("BookTitle: " + title);
    }

    // Tydzień 2, Wzorzec builder, Maciej Potręć
    // Implementacja klasy Builder dla klasy Book, wymaga ona, aby użytkownik podał tytuł, opis, listę autorów oraz datę publikacji (pola obowiązkowe)
    // natomiast reszta parametrów jest opcjonalna
    public static class Builder {
        private final String title;
        private final String description;
        private final List<Author> authors;
        private final Date publishedDate;
        private String genre;
        private String publisher;
        private int pages;
        private String ISBNIdentifier;
        private final BookFormat bookFormat;

        public Builder(String title, String description, List<Author> authors, Date publishedDate, BookFormat bookFormat) {
            this.title = title;
            this.description = description;
            this.authors = authors;
            this.publishedDate = publishedDate;
            this.bookFormat = bookFormat;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder ISBNIdentifier(String ISBNIdentifier) {
            this.ISBNIdentifier = ISBNIdentifier;
            return this;
        }

        public Book build() {
            return new Book(title, description, authors, publishedDate, genre, publisher, pages, ISBNIdentifier, bookFormat);
        }
    }
}

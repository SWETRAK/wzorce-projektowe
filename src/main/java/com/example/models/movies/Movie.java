package com.example.models.movies;

import com.example.models.Author;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class Movie {
        protected String title;
        protected String description;
        protected int duration;
        protected Date releaseDate;
        protected String genre;
        protected List<Author> authors;

        // Tydzień 1, Wzorzec prototype, Maciej Potręć
        // Metoda copy kopiuje obiekt Movie
        abstract Movie copy();
        // Koniec, Tydzień 1, Wzorzec prototype, Maciej Potręć


        // Tydzień 1, Wzorzec factory, Maciej Potręć
        // Metoda build buduje obiekt Movie (w klasach dziedziczących)
        abstract void build();
        // Koniec, Tydzień 1, Wzorzec factory, Maciej Potręć
}

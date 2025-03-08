package com.example.models.movies;

import com.example.models.Author;

import java.util.Date;
import java.util.List;

public class BlueRayMovie extends Movie {
    public BlueRayMovie(
            String title,
            String description,
            int duration,
            Date releaseDate,
            String genre,
            List<Author> authors
    ) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.authors = authors;
    }

    // Tydzień 1, Wzorzec prototype, Maciej Potręć
    // Nadpisanie, implementacja abstrakcyjnej metoda copy służąca do głębokiego kopiowania obiektu BlueRayMovie
    @Override
    public Movie copy() {
        return new BlueRayMovie(
                this.title,
                this.description,
                this.duration,
                this.releaseDate,
                this.genre,
                this.authors
        );
    }
    // Koniec, Wzorzec prototype, Maciej Potręć

    // Tydzień 1, Wzorzec factory, Maciej Potręć
    // Nadpisanie metody build, która akurat w tym wypadku wyświetla informacje o budowaniu obiektu BlueRayMovie
    @Override
    public void build() {
        System.out.println("Building " + this);
    }
    // Koniec, Wzorzec factory, Maciej Potręć
}

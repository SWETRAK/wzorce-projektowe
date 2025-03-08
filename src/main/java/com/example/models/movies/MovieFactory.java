package com.example.models.movies;

import com.example.models.Author;

import java.util.Date;
import java.util.List;

// Tydzień 1, Wzorzec factory, Maciej Potręć
// Klasa factory dla typu movie, która dziedziczy po abstrakcyjnej klasie generycznej, do której został przekazany typ Movie
// Metoda createMovie tworzy obiekt Movie na podstawie przekazanych parametrów i zwraca go jako obiekt generycznego typu
public abstract class MovieFactory<TMovieType extends Movie> {
    protected abstract TMovieType createMovie(String title, String description, int duration, Date releaseDate, String genre, List<Author> authors);

    public TMovieType create(String title, String description, int duration, Date releaseDate, String genre, List<Author> authors) {
        return createMovie(title, description, duration, releaseDate, genre, authors);
    }
}
// Koniec, Wzorzec factory, Maciej Potręć
package com.example.models.movies;

import com.example.models.Author;

import java.util.Date;
import java.util.List;


// Tydzień 1, Wzorzec factory, Maciej Potręć
// Klasa factory dla typu BlueRayMovie, która dziedziczy po abstrakcyjnej klasie generycznej, do której został przekazany typ BlueRayMovie
public class BlueRayMovieFactory extends MovieFactory<BlueRayMovie> {
    @Override
    public BlueRayMovie createMovie(String title, String description, int duration, Date releaseDate, String genre, List<Author> authors) {
        BlueRayMovie blueRayMovie = new BlueRayMovie(title, description, duration, releaseDate, genre, authors);
        blueRayMovie.build();

        return blueRayMovie;
    }
}
// Koniec, Wzorzec factory, Maciej Potręć

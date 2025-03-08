package com.example.models.movies;

import com.example.models.Author;

import java.util.Date;
import java.util.List;

// Tydzień 1, Wzorzec factory, Maciej Potręć
// Klasa factory dla typu DVDMovie, która dziedziczy po abstrakcyjnej klasie generycznej, do której został przekazany typ DVDMovie
public class DVDMovieFactory extends MovieFactory<DVDMovie> {
    @Override
    protected DVDMovie createMovie(String title, String description, int duration, Date releaseDate, String genre, List<Author> authors) {
        DVDMovie dvdMovie = new DVDMovie(title, description, duration, releaseDate, genre, authors);
        dvdMovie.build();

        return dvdMovie;
    }
}
// Koniec, Wzorzec factory, Maciej Potręć

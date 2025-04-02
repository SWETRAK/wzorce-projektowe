package com.example.services.recommendation;

//Tydzień 5, Wzorzec Interpreter, Joanna Kozar
//Implementacja finalnej rekomendacji książki z gatunkiem i rankingiem
public class BookRecommendationContext {
    private final String genre;
    private final double rating;

    public BookRecommendationContext(String genre, double rating) {
        this.genre = genre;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }
}
//Koniec - Tydzień 5, Wzorzec Interpreter, Joanna Kozar
package com.example.services.recommendation;

//Tydzień 5, Wzorzec Interpreter, Joanna Kozar
// Implementacja gatunku dla rekomendacji
public class GenreExpression implements Expression {
    private final String genre;

    public GenreExpression(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean interpret(BookRecommendationContext context) {
        return context.getGenre().equalsIgnoreCase(genre);
    }
}
//Koniec - Tydzień 5, Wzorzec Interpreter, Joanna Kozar
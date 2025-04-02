package com.example.services.recommendation;

//Tydzień 5, Wzorzec Interpreter, Joanna Kozar
// Implementacja rankingu dla rekomendacji
public class RatingExpression implements Expression {
    private final double minRating;

    public RatingExpression(double minRating) {
        this.minRating = minRating;
    }

    @Override
    public boolean interpret(BookRecommendationContext context) {
        return context.getRating() > minRating;
    }
}
//Koniec - Tydzień 5, Wzorzec Interpreter, Joanna Kozar
package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Wyrażenie do analizy ocen gwiazdkowych
public class StarRatingExpression implements SentimentExpression {
    private final int rating;
    private final String operator;

    public StarRatingExpression(String operator, int rating) {
        this.rating = rating;
        this.operator = operator;
    }

    @Override
    public boolean interpret(UserReview review) {
        int reviewRating = review.getRating().getValue();

        switch (operator) {
            case ">": return reviewRating > rating;
            case "<": return reviewRating < rating;
            case "=": return reviewRating == rating;
            case ">=": return reviewRating >= rating;
            case "<=": return reviewRating <= rating;
            default: return false;
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć

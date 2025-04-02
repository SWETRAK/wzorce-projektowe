package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Klasa reprezentująca wyrażenie sprawdzające, czy recenzja zawiera określone słowo
public class ContainsWordExpression implements SentimentExpression {
    private final String word;

    public ContainsWordExpression(String word) {
        this.word = word.toLowerCase();
    }

    @Override
    public boolean interpret(UserReview review) {
        return review.getReviewText().toLowerCase().contains(word);
    }
}

// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć
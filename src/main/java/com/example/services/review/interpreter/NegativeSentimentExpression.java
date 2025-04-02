package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

import java.util.Arrays;
import java.util.List;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Sprawdza negatywny sentyment na podstawie słów kluczowych
public class NegativeSentimentExpression implements SentimentExpression {
    private static final List<String> NEGATIVE_WORDS = Arrays.asList(
            "bad", "poor", "terrible", "horrible", "waste", "disappointing",
            "awful", "worst", "boring", "dislike", "hate"
    );

    @Override
    public boolean interpret(UserReview review) {
        String text = review.getReviewText().toLowerCase();
        return NEGATIVE_WORDS.stream().anyMatch(text::contains);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć

package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

import java.util.Arrays;
import java.util.List;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Sprawdza pozytywny sentyment na podstawie słów kluczowych
public class PositiveSentimentExpression implements SentimentExpression {
    private static final List<String> POSITIVE_WORDS = Arrays.asList(
            "great", "excellent", "good", "love", "amazing", "fantastic",
            "wonderful", "brilliant", "outstanding", "awesome", "enjoyed"
    );

    @Override
    public boolean interpret(UserReview review) {
        String text = review.getReviewText().toLowerCase();
        return POSITIVE_WORDS.stream().anyMatch(text::contains);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć

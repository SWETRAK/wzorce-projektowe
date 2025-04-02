package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Abstrakcja do analizy recenzji użytkowników
public interface SentimentExpression {
    boolean interpret(UserReview review);
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć

package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Wyrażenie do analizy recenzji użytkowników
public class AndExpression implements SentimentExpression {
    private final SentimentExpression expr1;
    private final SentimentExpression expr2;

    public AndExpression(SentimentExpression expr1, SentimentExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(UserReview review) {
        return expr1.interpret(review) && expr2.interpret(review);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć
package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Wyrażenie do negacji innego wyrażenia
public class NotExpression implements SentimentExpression {
    private final SentimentExpression expression;

    public NotExpression(SentimentExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(UserReview review) {
        return !expression.interpret(review);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć
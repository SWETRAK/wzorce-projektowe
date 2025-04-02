package com.example.services.review.interpreter;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Parser do analizy wyrażeń sentymentu
public class SentimentExpressionParser {

    public static SentimentExpression parse(String expression) {
        if (expression.contains(" AND ")) {
            String[] parts = expression.split(" AND ", 2);
            return new AndExpression(parse(parts[0]), parse(parts[1]));
        }

        if (expression.contains(" OR ")) {
            String[] parts = expression.split(" OR ", 2);
            return new OrExpression(parse(parts[0]), parse(parts[1]));
        }

        if (expression.startsWith("NOT ")) {
            return new NotExpression(parse(expression.substring(4)));
        }

        if (expression.startsWith("CONTAINS:")) {
            String word = expression.substring(9);
            return new ContainsWordExpression(word);
        }

        if (expression.startsWith("RATING")) {
            String operator = expression.substring(6, 7);
            int rating = Integer.parseInt(expression.substring(7));
            return new StarRatingExpression(operator, rating);
        }

        if (expression.equals("POSITIVE")) {
            return new PositiveSentimentExpression();
        }

        if (expression.equals("NEGATIVE")) {
            return new NegativeSentimentExpression();
        }

        throw new IllegalArgumentException("Nieprawidłowe wyrażenie: " + expression);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć

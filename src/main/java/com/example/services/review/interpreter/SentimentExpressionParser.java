package com.example.services.review.interpreter;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Parser do analizy wyrażeń sentymentu
public class SentimentExpressionParser {

    private static final int AND_SPLIT_LIMIT = 2;
    private static final int OR_SPLIT_LIMIT = 2;
    private static final int NOT_SUBSTRING_BEGIN_INDEX = 4;
    private static final int CONTAINS_SUBSTRING_BEGIN_INDEX = 9;

    private static final int RATING_SUBSTRING_BEGIN_INDEX = 6;
    private static final int RATING_SUBSTRING_END_INDEX = 7;

    public static SentimentExpression parse(String expression) {
        if (expression.contains(" AND ")) {
            String[] parts = expression.split(" AND ", AND_SPLIT_LIMIT);
            return new AndExpression(parse(parts[0]), parse(parts[1]));
        }

        if (expression.contains(" OR ")) {
            String[] parts = expression.split(" OR ", OR_SPLIT_LIMIT);
            return new OrExpression(parse(parts[0]), parse(parts[1]));
        }

        if (expression.startsWith("NOT ")) {
            return new NotExpression(parse(expression.substring(NOT_SUBSTRING_BEGIN_INDEX)));
        }

        if (expression.startsWith("CONTAINS:")) {
            String word = expression.substring(CONTAINS_SUBSTRING_BEGIN_INDEX);
            return new ContainsWordExpression(word);
        }

        if (expression.startsWith("RATING")) {
            String operator = expression.substring(RATING_SUBSTRING_BEGIN_INDEX, RATING_SUBSTRING_END_INDEX);
            int rating = Integer.parseInt(expression.substring(RATING_SUBSTRING_END_INDEX));
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

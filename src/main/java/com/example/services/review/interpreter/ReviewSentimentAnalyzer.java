package com.example.services.review.interpreter;

import com.example.services.review.flyweight.UserReview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Tydzień 5, Wzorzec Interpreter, Maciej Potręć
// Klasa do analizy sentymentu recenzji użytkowników
public class ReviewSentimentAnalyzer {
    private final Map<String, SentimentExpression> predefinedRules = new LinkedHashMap<>();

    public ReviewSentimentAnalyzer() {
        initializePredefinedRules();
    }

    private void initializePredefinedRules() {
        predefinedRules.put("Mixed",
                SentimentExpressionParser.parse("NEGATIVE OR POSITIVE AND RATING=3"));

        predefinedRules.put("Very Positive",
                SentimentExpressionParser.parse("POSITIVE AND RATING>4"));

        predefinedRules.put("Positive",
                SentimentExpressionParser.parse("POSITIVE OR RATING>3"));

        predefinedRules.put("Negative",
                SentimentExpressionParser.parse("NEGATIVE OR RATING<3"));

        predefinedRules.put("Very Negative",
                SentimentExpressionParser.parse("NEGATIVE AND RATING<2"));

        predefinedRules.put("Enthusiastic",
                SentimentExpressionParser.parse("CONTAINS:love OR CONTAINS:amazing"));
    }

    public String analyzeSentiment(UserReview review) {
        for (Map.Entry<String, SentimentExpression> rule : predefinedRules.entrySet()) {
            if (rule.getValue().interpret(review)) {
                return rule.getKey();
            }
        }
        return "Neutral";
    }

    public boolean matchesRule(UserReview review, String expressionString) {
        SentimentExpression expression = SentimentExpressionParser.parse(expressionString);
        return expression.interpret(review);
    }

    public void addRule(String ruleName, String expressionString) {
        predefinedRules.put(ruleName, SentimentExpressionParser.parse(expressionString));
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Maciej Potręć

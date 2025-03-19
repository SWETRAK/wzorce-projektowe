package com.example.services.recommendation;

// Tydzień 3, Wzorzec Bridge, Joanna Kozar
// Klasa zarządzająca strategią rekomendacji i jej wykonywaniem
public class RecommendationEngine {
    private RecommendationStrategy strategy;

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeRecommendation() {
        strategy.recommend();
    }
}

// Koniec - Tydzień 3, Wzorzec Bridge, Joanna Kozar
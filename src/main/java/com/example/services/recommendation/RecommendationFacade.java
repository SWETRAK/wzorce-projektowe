package com.example.services.recommendation;

// Tydzień 4, Wzorzec Facade, Joanna Kozar
// Klasa fasady upraszczająca dostęp do systemu rekomendacji
public class RecommendationFacade {
    private final RecommendationEngine engine;

    public RecommendationFacade() {
        this.engine = new RecommendationEngine();
    }

    public void recommendBasedOnHistory() {
        engine.setStrategy(new PurchaseHistoryRecommendation());
        engine.executeRecommendation();
    }
}

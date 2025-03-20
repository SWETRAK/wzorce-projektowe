package com.example.services.recommendation;

// Tydzień 3, Wzorzec Bridge, Joanna Kozar
// Konkretny typ strategii rekomendacji oparty na historii zakupów
public class PurchaseHistoryRecommendation implements RecommendationStrategy {
    @Override
    public void recommend() {
        System.out.println("Rekomendacja na podstawie historii zakupów to Czara Ognia");
    }
}
// Koniec - Tydzień 3, Wzorzec Bridge, Joanna Kozar
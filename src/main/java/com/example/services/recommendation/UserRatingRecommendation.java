package com.example.services.recommendation;

public class UserRatingRecommendation implements RecommendationStrategy {
    @Override
    public void recommend() {
        System.out.println("Rekomendacja na podstawie ocen użytkowników.");
    }
}

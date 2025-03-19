package com.example.services.review;

// Tydzień 3, Wzorzec Decorator, Joanna Kozar
// Dekorator rozszerzający funkcjonalność recenzji o premium oznaczenie
public class PremiumReviewDecorator implements Review {
    private final Review review;

    public PremiumReviewDecorator(Review review) {
        this.review = review;
    }

    @Override
    public String getContent() {
        return "Premium: " + review.getContent();
    }
}
//Koniec - Tydzień 3, Wzorzec Decorator, Joanna Kozar
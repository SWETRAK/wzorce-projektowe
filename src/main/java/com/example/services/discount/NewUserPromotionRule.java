package com.example.services.discount;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Promocja dla nowych użytkowników
public class NewUserPromotionRule implements PromotionRule {
    @Override
    public boolean isApplicable(String user) {
        return "NEW".equalsIgnoreCase(user);
    }
}
// Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
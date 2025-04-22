package com.example.services.discount;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Interfejs dla reguły promocji
public interface PromotionRule {
    boolean isApplicable(String user);
}
// Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
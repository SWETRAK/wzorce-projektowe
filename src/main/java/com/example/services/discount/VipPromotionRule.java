package com.example.services.discount;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Promocja dla klienta VIP
public class VipPromotionRule implements PromotionRule {
    @Override
    public boolean isApplicable(String user) {
        return "VIP".equalsIgnoreCase(user);
    }
}
// Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
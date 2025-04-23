package com.example.services.discount;
import java.util.List;

// Tydzień 7, Open/Closed Principle, Joanna Kozar
// Silnik promocji korzystający z listy reguł
public class PromotionEngine {
    private final List<PromotionRule> rules;

    public PromotionEngine(List<PromotionRule> rules) {
        this.rules = rules;
    }

    public void evaluatePromotions(String user) {
        for (PromotionRule rule : rules) {
            if (rule.isApplicable(user)) {
                System.out.println("Promocja przyznana dla: " + user);
                return;
            }
        }
        System.out.println("Brak promocji dla: " + user);
    }
}
// Koniec - Tydzień 7, Open/Closed Principle, Joanna Kozar
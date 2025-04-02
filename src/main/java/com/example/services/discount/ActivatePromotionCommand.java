package com.example.services.discount;

// Tydzien 5, Wzorzec Command, Joanna Kozar
// Implementacja aktywacji promocji
public class ActivatePromotionCommand implements DiscountCommand {
    private final DiscountManager discountManager;

    public ActivatePromotionCommand(DiscountManager discountManager) {
        this.discountManager = discountManager;
    }

    @Override
    public void execute() {
        discountManager.activatePromotion();
    }
}
//Koniec - Tydzien 5, Wzorzec Command, Joanna Kozar
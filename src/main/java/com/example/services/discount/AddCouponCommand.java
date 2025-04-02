package com.example.services.discount;

// Tydzien 5, Wzorzec Command, Joanna Kozar
// Implementacja dodawania kuponów
public class AddCouponCommand implements DiscountCommand {
    private final DiscountManager discountManager;
    private final String couponCode;

    public AddCouponCommand(DiscountManager discountManager, String couponCode) {
        this.discountManager = discountManager;
        this.couponCode = couponCode;
    }

    @Override
    public void execute() {
        discountManager.addCoupon(couponCode);
    }
}
//Koniec - Tydzien 5, Wzorzec Command, Joanna Kozar
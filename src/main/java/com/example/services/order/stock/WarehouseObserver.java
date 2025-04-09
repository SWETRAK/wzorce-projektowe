package com.example.services.order.stock;

import com.example.models.cart.ProductCartItem;

// Tydzień 6, Wzorzec Observer, Kamil Pietrak
// Konkretny obserwator reagujący na zmiany w magazynie
public class WarehouseObserver implements StockObserver {

    @Override
    public void update(ProductCartItem item) {
        System.out.println("Zarejestrowano zmiany w warehouse dla produktu" + item.getProduct().toString());
    }
}
// Koniec, Tydzień 6, Wzorzec Observer, Kamil Pietrak
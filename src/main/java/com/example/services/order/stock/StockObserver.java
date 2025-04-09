package com.example.services.order.stock;

import com.example.models.cart.ProductCartItem;

// Tydzień 6, Wzorzec Observer, Kamil Pietrak
// Interfejs reprezentujący obserwatora w systemie magazynowym
public interface StockObserver {

    void update(ProductCartItem item);
}
// Koniec, Tydzień 6, Wzorzec Observer, Kamil Pietrak
package com.example.models.cart;

import java.util.ArrayList;
import java.util.List;

public class Wishlist implements CartItem{

    private final List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double sum = items.stream().mapToDouble(CartItem::getPrice).sum();
        return Math.round(sum * 100.0) / 100.0;
    }

    @Override
    public void display() {
        System.out.println("Whishlist Contents:");
        items.forEach(CartItem::display);
    }
}

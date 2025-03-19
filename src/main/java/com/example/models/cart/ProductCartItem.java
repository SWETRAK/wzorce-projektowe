package com.example.models.cart;

import com.example.models.books.Book;

// Tydzień 3, Wzorzec Composite, Maciej Potręć
// Liść w strukturze Composite - pojedynczy produkt w koszyku
public class ProductCartItem implements CartItem {
    private final Object product;
    private final double price;
    private final int quantity;

    public ProductCartItem(Object product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double getPrice() {
        double sum = price * quantity;
        return Math.round(sum * 100.0) / 100.0;
    }

    @Override
    public void display() {
        String productName = "Unknown";
        if (product instanceof Book) {
            productName = ((Book) product).getTitle();
        }
        System.out.println("- " + productName + " x" + quantity + ": $" + getPrice());
    }
}
// Koniec, Tydzień 3, Wzorzec Composite, Maciej Potręć
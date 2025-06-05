package com.example.models.cart;

import com.example.models.cart.memento.CartMemento;

import java.util.ArrayList;
import java.util.List;

// Tydzień 3, Wzorzec Composite, Maciej Potręć
// Kompozyt - koszyk zakupowy zawierający wiele elementów
public class ShoppingCart implements CartItem, CartIterator {
    private List<CartItem> items = new ArrayList<>();
    private int index = 0;


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
        System.out.println("Shopping Cart Contents:");
        items.forEach(CartItem::display);
        System.out.println("Total: $" + getPrice());
    }

    // Tydzień 5, Wzorzec Iterator, Kamil Pietrak
    // Klasa iteratora do iterowania po książkach w koszyku
    @Override
    public boolean hasNext() {
        return index < items.size();
    }

    @Override
    public CartItem next() {
        return items.get(index++);
    }

    @Override
    public CartItem getPrevious() {
        return items.get(--index);
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }
    // Koniec, Tydzień 5, Wzorzec Iterator, Kamil Pietrak

    // Tydzień 6, Wzorzec Memento, Maciej Potręć
    // Metody do zapisywania i przywracania stanu koszyka
    public CartMemento save() {
        return new CartMemento(new ArrayList<>(items));
    }

    public void restore(CartMemento memento) {
        this.items = new ArrayList<>(memento.getSavedItems());
    }
    // Koniec, Tydzień 6, Wzorzec Memento, Maciej Potręć
}
// Koniec, Tydzień 3, Wzorzec Composite, Maciej Potręć

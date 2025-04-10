package com.example.models.books;

import com.example.services.reporting.ProductVisitor;

import java.util.ArrayList;
import java.util.List;

// Tydzień 3, Wzorzec Composite, Joanna Kozar
// Klasa reprezentująca kategorię książek, która może zawierać inne książki lub kategorie
public class Category implements BookComponent {
    private final String name;
    private final List<BookComponent> components = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addComponent(BookComponent component) {
        components.add(component);
    }

    @Override
    public void displayBookTitle() {
        System.out.println("Kategoria: " + name);
        for (BookComponent component : components) {
            component.displayBookTitle();
        }
    }

    @Override
    public void accept(ProductVisitor visitor) {
        for (BookComponent component : components) {
            component.accept(visitor);
        }
    }

}
// Koniec - Tydzień 3, Wzorzec Composite, Joanna Kozar

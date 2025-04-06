package com.example.services.books.strategy;

import com.example.models.books.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Tydzień 6, Wzorzec Strategy, Maciej Potręć
// Klasa implementująca strategię sortowania książek według daty publikacji.
public class DateSortingStrategy implements BookSortingStrategy {
    @Override
    public List<Book> sort(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getPublishedDate).reversed())
                .collect(Collectors.toList());
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy, Maciej Potręć

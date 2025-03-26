package com.example.services.review.flyweight;

import lombok.Getter;
import lombok.ToString;

// Tydzień 4, Wzorzec Flyweight, Maciej Potręć
// Klasa reprezentująca tagi recenzji
@Getter
@ToString
public class ReviewTag {
    private final String name;
    
    public ReviewTag(String name) {
        this.name = name;
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight

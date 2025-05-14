package com.example.services.review.flyweight;

// Tydzień 4, Wzorzec Flyweight, Maciej Potręć
// Klasa reprezentująca ocenę (1-5)
public class Rating {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 5;

    private final int value;
    
    public Rating(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value + " stars";
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Maciej Potręć

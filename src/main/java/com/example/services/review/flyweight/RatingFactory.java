package com.example.services.review.flyweight;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Maciej Potręć
// Fabryka dla ocen
@Getter
public class RatingFactory {
    private static final Map<Integer, Rating> ratings = new HashMap<>();
    
    public static Rating getRating(int value) {
        if (!ratings.containsKey(value)) {
            ratings.put(value, new Rating(value));
        }
        return ratings.get(value);
    }

    public static int getRatingCount() {
        return ratings.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Maciej Potręć

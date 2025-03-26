package com.example.services.review.flyweight;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Maciej Potręć
// Fabryka dla tagów recenzji
@Getter
public class ReviewTagFactory {
    private static final Map<String, ReviewTag> tags = new HashMap<>();

    public static ReviewTag getTag(String name) {
        if (!tags.containsKey(name)) {
            tags.put(name, new ReviewTag(name));
        }
        return tags.get(name);
    }

    public static int getTagCount() {
        return tags.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Maciej Potręć

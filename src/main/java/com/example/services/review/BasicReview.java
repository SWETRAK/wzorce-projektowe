package com.example.services.review;

// Tydzień 3, Wzorzec Decorator, Joanna Kozar
// Konkretny komponent - podstawowa recenzja
public class BasicReview implements Review {
    private final String content;

    public BasicReview(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
// Koniec -Tydzień 3, Wzorzec Decorator, Joanna Kozar
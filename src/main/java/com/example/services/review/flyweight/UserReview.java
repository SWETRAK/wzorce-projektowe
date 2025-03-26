package com.example.services.review.flyweight;

import com.example.models.users.Client;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Tydzień 4, Wzorzec Flyweight, Maciej Potręć
// Klasa reprezentująca recenzję użytkownika
@Getter
@ToString
public class UserReview {
    private String reviewText;
    private Rating rating;
    private LocalDateTime creationDate;
    private Client client;
    private List<ReviewTag> tags;

    public UserReview(String reviewText, int rating, Client client) {
        this.reviewText = reviewText;
        this.rating = RatingFactory.getRating(rating);
        this.creationDate = LocalDateTime.now();
        this.client = client;
        this.tags = new ArrayList<>();
    }

    public void addTag(String tagName) {
        ReviewTag tag = ReviewTagFactory.getTag(tagName);
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public void removeTag(String tagName) {
        ReviewTag tag = ReviewTagFactory.getTag(tagName);
        tags.remove(tag);
    }

    public void updateReviewText(String newText) {
        this.reviewText = newText;
    }

    public void updateRating(int newRating) {
        this.rating = RatingFactory.getRating(newRating);
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Maciej Potręć

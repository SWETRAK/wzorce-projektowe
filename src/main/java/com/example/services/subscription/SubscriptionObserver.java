package com.example.services.subscription;

import com.example.models.papers.Paper;

// Tydzień 6, Wzorzec Observer, Maciej Potręć
// Klasa reprezentująca obserwatora subskrypcji
public interface SubscriptionObserver {
    void update(Paper paper, String issueTitle, String message);
    String getEmail();
}
// Koniec, Tydzień 6, Wzorzec Observer, Maciej Potręć

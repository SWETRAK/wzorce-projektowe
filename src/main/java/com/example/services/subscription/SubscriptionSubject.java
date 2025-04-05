package com.example.services.subscription;

import com.example.models.papers.Paper;

// Tydzień 6, Wzorzec Observer, Maciej Potręć
// Klasa w której zdefiniowano metody do rejestracji, usuwania i powiadamiania obserwatorów subskrypcji
public interface SubscriptionSubject {
    void registerObserver(SubscriptionObserver observer, String publicationType);
    void removeObserver(SubscriptionObserver observer, String publicationType);
    void notifyObservers(Paper publication, String issueTitle, String message);
}
// Koniec, Tydzień 6, Wzorzec Observer, Maciej Potręć

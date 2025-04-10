package com.example.services.subscription;

import com.example.models.papers.Magazine;
import com.example.models.papers.Paper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Tydzień 6, Wzorzec Observer, Maciej Potręć
// Klasa do zarządzania subskrypcjami publikacji
public class PublicationSubscriptionService implements SubscriptionSubject {
    private Map<String, List<SubscriptionObserver>> subscribers = new HashMap<>();
    private static PublicationSubscriptionService instance;

    private PublicationSubscriptionService() {
    }

    public static PublicationSubscriptionService getInstance() {
        if (instance == null) {
            instance = new PublicationSubscriptionService();
        }
        return instance;
    }

    @Override
    public void registerObserver(SubscriptionObserver observer, String publicationType) {
        if (!subscribers.containsKey(publicationType)) {
            subscribers.put(publicationType, new ArrayList<>());
        }
        List<SubscriptionObserver> publicationSubscribers = subscribers.get(publicationType);
        if (!publicationSubscribers.contains(observer)) {
            publicationSubscribers.add(observer);
            System.out.println("Subscriber " + observer.getEmail() + " registered for " + publicationType);
        }
    }

    @Override
    public void removeObserver(SubscriptionObserver observer, String publicationType) {
        if (subscribers.containsKey(publicationType)) {
            List<SubscriptionObserver> publicationSubscribers = subscribers.get(publicationType);
            publicationSubscribers.remove(observer);
            System.out.println("Subscriber " + observer.getEmail() + " unsubscribed from " + publicationType);
        }
    }

    @Override
    public void notifyObservers(Paper publication, String issueTitle, String message) {
        String publicationType = publication.getTitle();
        if (subscribers.containsKey(publicationType)) {
            System.out.println("\n Notifying subscribers about new issue of " + publicationType + ": " + issueTitle);
            for (SubscriptionObserver observer : subscribers.get(publicationType)) {
                observer.update(publication, issueTitle, message);
            }
        }
    }

    public void publishNewIssue(Paper publication, String issueTitle, String description) {
        String publicationType = publication.getTitle();
        String message = "New issue of " + publicationType + " is now available: " + issueTitle;
        System.out.println("Publishing new " + (publication.getClass().getSimpleName()) +
                ": " + publicationType + " - " + issueTitle);
        notifyObservers(publication, issueTitle, message);
    }

    public int getSubscriberCount(String publicationType) {
        if (subscribers.containsKey(publicationType)) {
            return subscribers.get(publicationType).size();
        }
        return 0;
    }
}
// Koniec, Tydzień 6, Wzorzec Observer, Maciej Potręć

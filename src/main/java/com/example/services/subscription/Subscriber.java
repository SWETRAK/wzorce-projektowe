package com.example.services.subscription;

import com.example.models.papers.Paper;
import com.example.models.users.Client;
import lombok.Getter;
import lombok.Setter;

// Tydzień 6, Wzorzec Observer, Maciej Potręć
// Klasa reprezentująca subskrybenta, implementująca interfejs SubscriptionObserver
@Getter
@Setter
public class Subscriber implements SubscriptionObserver {
    private final Client client;

    public Subscriber(Client client) {
        this.client = client;
    }

    @Override
    public void update(Paper publication, String issueTitle, String message) {
        System.out.println("[Email to: " + client.getEmail() + "] " + message);
        System.out.println("  Dear " + client.getFirstName() + ", " + issueTitle + " is now available!");
        System.out.println("  Details: " + publication.getDescription());
        System.out.println("  Publication date: " + publication.getPublishedDate());
    }

    public void subscribe(String publicationType) {
        PublicationSubscriptionService.getInstance().registerObserver(this, publicationType);
    }

    public void unsubscribe(String publicationType) {
        PublicationSubscriptionService.getInstance().removeObserver(this, publicationType);
    }

    public String getEmail() {
        return client.getEmail();
    }
}
// Koniec, Tydzień 6, Wzorzec Observer, Maciej Potręć

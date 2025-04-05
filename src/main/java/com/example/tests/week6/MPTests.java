package com.example.tests.week6;

import com.example.models.papers.Magazine;
import com.example.models.papers.MagazineFactory;
import com.example.models.papers.Newspaper;
import com.example.models.papers.NewspaperFactory;
import com.example.models.users.Client;
import com.example.services.subscription.PublicationSubscriptionService;
import com.example.services.subscription.Subscriber;

import java.util.Date;

public class MPTests {

    public static void main(String[] args) {
        testObserver();
    }

    private static void testObserver() {
        System.out.println("\n--- Observer Pattern Test ---");

        PublicationSubscriptionService subscriptionService = PublicationSubscriptionService.getInstance();

        Client client1 = new Client.Builder("Jan", "Kowalski", "jan.kowalski@example.com")
                .phoneNumber("123456789")
                .build();
        Client client2 = new Client.Builder("Janek", "Kowalski", "janek.kowalski@example.com")
                .phoneNumber("123456789")
                .build();
        Client client3 = new Client.Builder("Dzbanek", "Kowalski", "dzbanek.kowalski@example.com")
                .phoneNumber("123456789")
                .build();
        Client client4 = new Client.Builder("Franek", "Kowalski", "franek.kowalski@example.com")
                .phoneNumber("555-123-4567")
                .build();

        Subscriber subscriber1 = new Subscriber(client1);
        Subscriber subscriber2 = new Subscriber(client2);
        Subscriber subscriber3 = new Subscriber(client3);
        Subscriber subscriber4 = new Subscriber(client4);

        subscriber1.subscribe("Scientific American");
        subscriber1.subscribe("National Geographic");
        subscriber2.subscribe("Scientific American");
        subscriber3.subscribe("Scientific American");
        subscriber4.subscribe("The New York Times");

        // Check subscriber counts
        System.out.println("\nSubscriber counts:");
        System.out.println("Scientific American: " +
                subscriptionService.getSubscriberCount("Scientific American"));
        System.out.println("National Geographic: " +
                subscriptionService.getSubscriberCount("National Geographic"));
        System.out.println("The New York Times: " +
                subscriptionService.getSubscriberCount("The New York Times"));


        // Create publications using factories
        MagazineFactory magazineFactory = new MagazineFactory();

        Magazine scientificAmerican = magazineFactory.create("1234-5678");
        scientificAmerican.setTitle("Scientific American");
        scientificAmerican.setDescription("Popular science magazine");
        scientificAmerican.setPublishedDate(new Date());
        scientificAmerican.setArticleNumber(12);

        Magazine nationalGeographic = magazineFactory.create("2345-6789");
        nationalGeographic.setTitle("National Geographic");
        nationalGeographic.setDescription("Nature and culture magazine");
        nationalGeographic.setPublishedDate(new Date());
        nationalGeographic.setArticleNumber(5);

        NewspaperFactory newspaperFactory = new NewspaperFactory();
        Newspaper newYorkTimes = newspaperFactory.create("3456-7890");
        newYorkTimes.setTitle("The New York Times");
        newYorkTimes.setDescription("Daily newspaper");
        newYorkTimes.setPublishedDate(new Date());
        newYorkTimes.setPages(20);

        // Publish new issues
        subscriptionService.publishNewIssue(scientificAmerican, "New Issue of Scientific American", "New issue is out!");
        subscriptionService.publishNewIssue(nationalGeographic, "New Issue of National Geographic", "New issue is out!");
        subscriptionService.publishNewIssue(newYorkTimes, "New Issue of The New York Times", "New issue is out!");

        // Unsubscribe a client
        subscriber1.unsubscribe("Scientific American");
        System.out.println("\nSubscriber counts after unsubscription:");
        System.out.println("Scientific American: " +
                subscriptionService.getSubscriberCount("Scientific American"));

        subscriptionService.publishNewIssue(scientificAmerican, "New Issue of Scientific American", "New issue is out!");
    }
}

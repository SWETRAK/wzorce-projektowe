package com.example.tests.week6;

import com.example.models.Author;
import com.example.models.books.AudioBook;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.papers.Magazine;
import com.example.models.papers.MagazineFactory;
import com.example.models.papers.Newspaper;
import com.example.models.papers.NewspaperFactory;
import com.example.models.users.Client;
import com.example.services.books.strategy.*;
import com.example.services.order.Order;
import com.example.services.order.state.OrderStateService;
import com.example.services.subscription.PublicationSubscriptionService;
import com.example.services.subscription.Subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MPTests {

    public static void main(String[] args) {
//        testObserver();
//        testState();
        testStrategy();
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

    private static void testState() {
        System.out.println("\n--- State Pattern Test (Order State Management) ---");

        OrderStateService orderService = OrderStateService.getInstance();

        // Create a new order
        Order order1 = orderService.createOrder("customer@example.com", 129.99);
        String orderId1 = order1.getOrderId();

        Order order2 = orderService.createOrder("another@example.com", 75.50);
        String orderId2 = order2.getOrderId();

        // Process first order
        System.out.println("\nProcessing first order:");
        orderService.processOrder(orderId1);
        orderService.printOrderStatus(orderId1);

        // Ship first order
        System.out.println("\nShipping first order:");
        orderService.shipOrder(orderId1);
        orderService.printOrderStatus(orderId1);

        // Try to ship second order without processing (should show error)
        System.out.println("\nAttempting to ship second order without processing:");
        orderService.shipOrder(orderId2);
        orderService.printOrderStatus(orderId2);

        // Process and then cancel second order
        System.out.println("\nProcessing second order:");
        orderService.processOrder(orderId2);
        System.out.println("\nCancelling second order:");
        orderService.cancelOrder(orderId2);
        orderService.printOrderStatus(orderId2);

        // Deliver first order
        System.out.println("\nDelivering first order:");
        orderService.deliverOrder(orderId1);
        orderService.printOrderStatus(orderId1);

        // Try to cancel delivered order (should show error)
        System.out.println("\nAttempting to cancel delivered order:");
        orderService.cancelOrder(orderId1);
        orderService.printOrderStatus(orderId1);
    }

    private static void testStrategy()
    {
        System.out.println("\n--- Strategy Pattern Test (Book Sorting) ---");

        Author author1 = new Author("Andrzej", "Sapkowski");
        Author author2 = new Author("John Ronald Reuel", "Tolkien");

        Book book1 = new Book.Builder("The Last Wish", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        Book book2 = new Book.Builder("The Hobbit", "Desc", Collections.singletonList(author2), new Date(), new AudioBook())
                .ISBNIdentifier("054792822X")
                .genre("Fantasy")
                .publisher("George Allen & Unwin")
                .pages(310)
                .build();

        Book book3 = new Book.Builder("The Witcher", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Not Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        Book book4 = new Book.Builder("The Lord of the Rings", "Desc", Collections.singletonList(author2), new Date(), new AudioBook())
                .ISBNIdentifier("054792822X")
                .genre("Action")
                .publisher("George Allen & Unwin")
                .pages(350)
                .build();

        List<Book> books = new ArrayList<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        BookCatalog bookCatalog = new BookCatalog(books);
        bookCatalog.setSortingStrategy(new DateSortingStrategy());

        System.out.println("Books sorted by date:");
        for (Book book : bookCatalog.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getPublishedDate());
        }

        bookCatalog.setSortingStrategy(new GenreSortingStrategy());
        System.out.println("\nBooks sorted by genre:");
        for (Book book : bookCatalog.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getGenre());
        }

        bookCatalog.setSortingStrategy(new PageCountSortingStrategy());

        System.out.println("\nBooks sorted by page count:");
        for (Book book : bookCatalog.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getPages());
        }

        bookCatalog.setSortingStrategy(new PublisherSortingStrategy());

        System.out.println("\nBooks sorted by publisher:");
        for (Book book : bookCatalog.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getPublisher());
        }

        bookCatalog.setSortingStrategy(new AuthorSortingStrategy());
        System.out.println("\nBooks sorted by author:");
        for (Book book : bookCatalog.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getAuthors());
        }

        bookCatalog.setSortingStrategy(new TitleSortingStrategy());

        System.out.println("\nBooks sorted by title:");
        for (Book book : bookCatalog.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getTitle());
        }
    }
}

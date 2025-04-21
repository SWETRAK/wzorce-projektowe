package com.example.tests.week5;

import com.example.models.books.Book;
import com.example.models.users.Client;
import com.example.services.books.WarehouseRepository;
import com.example.services.books.iterator.BookSearchIterator;
import com.example.services.books.iterator.BookSearchResults;
import com.example.services.books.iterator.EnhancedBookSearchEngine;
import com.example.services.customer.*;
import com.example.services.order.command.*;
import com.example.services.review.flyweight.UserReview;
import com.example.services.review.interpreter.ReviewSentimentAnalyzer;

public class MPTests {

    public static void main(String[] args) {
        testCommand();
        testInterpreter();
        testIterator();
        testMediator();
    }

    private static void testCommand()
    {
        System.out.println("\n--- Command Pattern Test ---");

        OrderProcessor processor = new OrderProcessor();

        OrderCommand approveOrder = new ApproveOrderCommand(processor, "123");
        OrderCommand cancelOrder = new CancelOrderCommand(processor, "124");
        OrderCommand returnOrder = new ReturnOrderCommand(processor, "125", "Damaged item");


        OrderCommandInvoker invoker = new OrderCommandInvoker();

        invoker.executeCommand(approveOrder);
        invoker.executeCommand(cancelOrder);
        invoker.executeCommand(returnOrder);

        invoker.printHistory();

        invoker.undoLastCommand();

        invoker.printHistory();
    }

    private static void testInterpreter()
    {
        System.out.println("\n--- Interpreter Pattern Test ---");

        Client client = new Client.Builder("Jan", "Kowalski", "jan.kowalski@example.com")
                .phoneNumber("123456789")
                .build();

        UserReview positiveReview = new UserReview(
                "Good book! Wyśmienita",
                5, client);

        UserReview negativeReview = new UserReview(
                "Boring book!",
                1, client);

        UserReview mixedReview = new UserReview(
                "Boring good book!",
                3, client);

        ReviewSentimentAnalyzer analyzer = new ReviewSentimentAnalyzer();

        System.out.println("Positive review sentiment: " + analyzer.analyzeSentiment(positiveReview));
        System.out.println("Negative review sentiment: " + analyzer.analyzeSentiment(negativeReview));
        System.out.println("Mixed review sentiment: " + analyzer.analyzeSentiment(mixedReview));

        analyzer.addRule("Contains Plot", "CONTAINS:plot");

        System.out.println("\nTesting custom rules:");
        System.out.println("Positive review contains 'wyśmienita': " +
                analyzer.matchesRule(positiveReview, "CONTAINS:wyśmienita"));
        System.out.println("Negative review contains 'boring': " +
                analyzer.matchesRule(negativeReview, "CONTAINS:boring"));

        System.out.println("\nTesting complex rules:");
        System.out.println("Positive review - (5 stars AND mentions 'wyśmienita'): " +
                analyzer.matchesRule(positiveReview, "RATING=5 AND CONTAINS:wyśmienita"));
    }

    private static void testIterator()
    {
        System.out.println("\n--- Iterator Pattern Test ---");

        EnhancedBookSearchEngine searchEngine = new EnhancedBookSearchEngine(new WarehouseRepository());

        BookSearchResults results = searchEngine.findBooksByTitle("Harry Potter");

        BookSearchIterator iterator = results.createIterator();

        System.out.println("Found " + results.size() + " books matching the search criteria.");
        System.out.println("Iterating through the results:");

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book != null) {
                System.out.println(" - " + book.getTitle() + " by " +
                        book.getAuthors().get(0).firstName() + " " +
                        book.getAuthors().get(0).lastName());
            }
        }

        System.out.println("\nResetting iterator and showing first result:");
        iterator.reset();
        if (iterator.hasNext()) {
            Book firstBook = iterator.next();
            if (firstBook != null) {
                System.out.println(" - " + firstBook.getTitle());
            }
        }
    }

    private static void testMediator()
    {
        System.out.println("\n--- Mediator Pattern Test ---");

        CustomerServiceMediator mediator = new CustomerServiceMediatorImpl();

        ChatBot chatBot = new ChatBot(mediator, "ChatBot");
        Consultant consultant = new Consultant(mediator, "Consultant");
        KnowledgeBase knowledgeBase = new KnowledgeBase(mediator, "KnowledgeBase");

        System.out.println("=== Test 1: Simple shipping question ===");
        // Zapytanie do chatbota na które on powinien znaleść odpowiedź w bazie wiedzy
        mediator.routeQuery(null, "What are your shipping options?", "customer123");

        System.out.println("\n=== Test 2: Complex return question ===");
        // Zapytanie do chatbota na które on nie znajdzie odpowiedzi w bazie wiedzy więc prześle do konsultanta
        mediator.routeQuery(null, "My book arrived damaged, what should I do?", "customer456");

        System.out.println("\n=== Test 3: Direct consultant question ===");
        // Bezpośrednie zapytanie do konsultanta
        consultant.receiveQuery("I need help with my account", "customer789");
    }
}

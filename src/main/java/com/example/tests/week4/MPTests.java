package com.example.tests.week4;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.books.PhysicalBook;
import com.example.models.cart.ProductCartItem;
import com.example.models.cart.ShoppingCart;
import com.example.models.discount.*;
import com.example.models.discount.proxy.DiscountServiceProxy;
import com.example.models.discount.proxy.RealDiscountService;
import com.example.models.users.Client;
import com.example.services.delivery.DeliveryService;
import com.example.services.delivery.InPostServiceAdapter;
import com.example.services.order.facade.OrderFacade;
import com.example.services.payment.PayPalAdapter;
import com.example.services.payment.PayPalPayment;
import com.example.services.payment.PaymentProcessor;
import com.example.services.review.flyweight.RatingFactory;
import com.example.services.review.flyweight.ReviewTagFactory;
import com.example.services.review.flyweight.UserReview;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MPTests {
    public static void main(String[] args) {
        testFacade();
        testProxy();
        testFlyweight();
    }

    private static void testFacade() {
        System.out.println("\n--- Facade Pattern Test ---");

        Client regularClient = new Client.Builder("Klient", "Zwykły", "klient.zwykly@gmail.com")
                .phoneNumber("123456789")
                .address("ul. Nadbystrzycka 36, 20-618 Lublin")
                .build();

        Book book1 = new Book.Builder(
                "Bardzo zwyczajna książka",
                "Opis",
                Collections.singletonList(new Author("Imie", "Nazwisko")),
                new Date(),
                new PhysicalBook()
        ).build();

        Book book2 = new Book.Builder(
                "Bardzo zwyczajna książka 2",
                "Opis",
                Collections.singletonList(new Author("Imie 2", "Nazwisko 2")),
                new Date(),
                new PhysicalBook()
        ).build();

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new ProductCartItem(book1, 21.37, 5));
        cart.addItem(new ProductCartItem(book2, 42.00, 2));

        DeliveryService inPostDelivery = new InPostServiceAdapter();

        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalPayment());

        OrderFacade orderFacade = new OrderFacade();
        orderFacade.processOrder(regularClient, cart, paypalProcessor, inPostDelivery);
    }

    private static void testProxy() {
        System.out.println("\n--- Proxy Pattern Test ---");

        Client regularClient = new Client.Builder("Klient", "Zwykły", "klient.zwykly@gmail.com")
                .phoneNumber("123456789")
                .build();
        Client premiumClient = new Client.Builder("Klient", "Premium", "klient.premium@gmail.com")
                .phoneNumber("123456788")
                .build();
        Client unauthorizedClient = new Client.Builder("Klient", "Nautoryzowany", "klient.nautoryzowany@gmail.com")
                .phoneNumber("123456787")
                .build();

        RealDiscountService realService = new RealDiscountService();

        PriceDiscount tenPercentOff = new SingleDiscount(0.9);
        PriceDiscount twentyPercentOff = new SingleDiscount(0.8);
        PriceDiscount discountForAll = new SingleDiscount(0.95);

        Set<String> eligibleForBasic = new HashSet<>();
        eligibleForBasic.add(regularClient.getEmail());
        eligibleForBasic.add(premiumClient.getEmail());

        Set<String> eligibleForPremium = new HashSet<>();
        eligibleForPremium.add(premiumClient.getEmail());

        realService.registerDiscount("BASIC10", tenPercentOff, eligibleForBasic);
        realService.registerDiscount("PREMIUM20", twentyPercentOff, eligibleForPremium);
        realService.registerDiscount("BASE5", discountForAll); // Zniżka dla wszystkich

        DiscountServiceProxy proxyService = new DiscountServiceProxy(realService);

        double originalPrice = 100.0;

        System.out.println("\nRegular client using BASIC10:");
        double regularPrice = proxyService.applyDiscount(regularClient, originalPrice, "BASIC10");
        System.out.println("Original price: $" + originalPrice + ", After discount: $" + regularPrice);
        // Cena powinna być zcache'owana dlatego powtórne zastosowanie zniżki nie zadziała
        regularPrice = proxyService.applyDiscount(regularClient, originalPrice, "BASIC10");
        System.out.println("Original price: $" + originalPrice + ", After discount: $" + regularPrice);

        System.out.println("\nPremium client using PREMIUM20:");
        double premiumPrice = proxyService.applyDiscount(premiumClient, originalPrice, "PREMIUM20");
        System.out.println("Original price: $" + originalPrice + ", After discount: $" + premiumPrice);

        System.out.println("\nUnauthorized client trying to use BASIC10:");
        double unauthorizedPrice = proxyService.applyDiscount(unauthorizedClient, originalPrice, "BASIC10");
        System.out.println("Original price: $" + originalPrice + ", After discount: $" + unauthorizedPrice);

        System.out.println("\nRegular client trying to use PREMIUM20:");
        double regularPremiumPrice = proxyService.applyDiscount(regularClient, originalPrice, "PREMIUM20");
        System.out.println("Original price: $" + originalPrice + ", After discount: $" + regularPremiumPrice);

        // Test caching
        System.out.println("\nTesting caching - Premium client using PREMIUM20 again (should be cached):");
        double cachedPremiumPrice = proxyService.applyDiscount(premiumClient, originalPrice, "PREMIUM20");
        System.out.println("Original price: $" + originalPrice + ", After discount: $" + cachedPremiumPrice);

        System.out.println("\nTesting base discount - Regular client using BASE5:");
        double baseDiscountPrice = proxyService.applyDiscount(regularClient, originalPrice, "BASE5");
        System.out.println("Original price: $" + originalPrice + ", After discount: $" + baseDiscountPrice);

    }

    private static void testFlyweight() {
        System.out.println("\n--- Flyweight Pattern Test ---");

        Client regularClient1 = new Client.Builder("Klient", "Zwykły", "klient.zwykly@gmail.com")
                .phoneNumber("123456789")
                .build();

        Client regularClient2 = new Client.Builder("Klient", "Zwykły", "klient.zwykly@gmail.com")
                .phoneNumber("123456789")
                .build();

        Client regularClient3 = new Client.Builder("Klient", "Zwykły", "klient.zwykly@gmail.com")
                .phoneNumber("123456789")
                .build();

        Client regularClient4 = new Client.Builder("Klient", "Zwykły", "klient.zwykly@gmail.com")
                .phoneNumber("123456789")
                .build();

        // Create multiple reviews with the same ratings to demonstrate reuse
        System.out.println("Creating reviews with flyweight objects...");
        UserReview review1 = new UserReview("Great book!", 5, regularClient1);
        UserReview review2 = new UserReview("Decent read", 3, regularClient2);
        UserReview review3 = new UserReview("Loved it", 5, regularClient3);
        UserReview review4 = new UserReview("Not bad", 3, regularClient4);

        // Add common tags to demonstrate tag reuse
        review1.addTag("fiction");
        review1.addTag("thriller");

        review2.addTag("fiction");
        review2.addTag("slow-paced");

        review3.addTag("fiction");
        review3.addTag("thriller");
        review3.addTag("page-turner");

        review4.addTag("fiction");
        review4.addTag("slow-paced");

        // Demonstrate memory usage
        System.out.println("\nMemory usage with Flyweight pattern:");
        System.out.println("Number of unique Rating objects: " + RatingFactory.getRatingCount());
        System.out.println("Number of Rating references in reviews: 4");

        System.out.println("\nNumber of unique ReviewTag objects: " + ReviewTagFactory.getTagCount());

        // Count total tag references
        int totalTagReferences = review1.getTags().size() +
                              review2.getTags().size() +
                              review3.getTags().size() +
                              review4.getTags().size();
        System.out.println("Number of ReviewTag references in reviews: " + totalTagReferences);

        // Demonstrate object identity (same objects are reused)
        System.out.println("\nDemonstrating object reuse:");
        System.out.println("review1 and review3 have same 5-star rating object: " +
                        (review1.getRating() == review3.getRating()));
        System.out.println("review2 and review4 have same 3-star rating object: " +
                        (review2.getRating() == review4.getRating()));

        // Show that the same tag objects are reused
        System.out.println("\nTag 'fiction' is shared across reviews:");
        System.out.println("review1 and review2 share the same 'fiction' tag object: " +
                        (review1.getTags().get(0) == review2.getTags().get(0)));

        // Demonstrate memory savings
        System.out.println("\nWithout flyweight, we would need:");
        System.out.println("- 4 separate Rating objects instead of " + RatingFactory.getRatingCount());
        System.out.println("- " + totalTagReferences + " separate ReviewTag objects instead of " +
                        ReviewTagFactory.getTagCount());

        // Display reviews
        System.out.println("\nReviews created:");
        System.out.println("Review 1: " + review1);
        System.out.println("Review 2: " + review2);
        System.out.println("Review 3: " + review3);
        System.out.println("Review 4: " + review4);
    }
}

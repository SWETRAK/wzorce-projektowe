package com.example.tests.week3;

import com.example.models.Author;
import com.example.models.books.*;
import com.example.services.payment.*;
import com.example.services.recommendation.*;
import com.example.services.review.*;

import java.util.Collections;
import java.util.Date;

// Tydzień 3, Testowanie wzorców projektowych, Joanna Kozar
// Klasa testowa sprawdzająca działanie wzorców: Adapter, Composite, Bridge, Decorator
public class JKTest {
    public static void main(String[] args) {
        // Adapter - płatności
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalPayment());
        PaymentProcessor stripeProcessor = new BlikAdapter(new BlikPayment());

        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);

        // Composite - kategorie książek
        Author author1 = new Author("Andrzej", "Sapkowski");

        // Tworzenie książki przy użyciu Buildera
        BookComponent book1 = new Book.Builder(
                "The Last Wish",
                "Desc",
                Collections.singletonList(author1),
                new Date(),
                new Ebook()
        )
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        BookComponent book2 = new Book.Builder(
                "Władca Pierścieni",
                "Epicka przygoda w Śródziemiu",
                Collections.singletonList(new Author("J.R.R.", "Tolkien")),
                new Date(),
                new AudioBook()
        )
                .ISBNIdentifier("9780261103573")
                .genre("Fantasy")
                .publisher("HarperCollins")
                .pages(1216)
                .build();

        BookComponent book3 = new Book.Builder(
                "Harry Potter i Kamień Filozoficzny",
                "Początek magicznej serii o młodym czarodzieju",
                Collections.singletonList(new Author("J.K.", "Rowling")),
                new Date(),
                new Ebook()
        )
                .ISBNIdentifier("9780747532699")
                .genre("Fantasy")
                .publisher("Bloomsbury")
                .pages(223)
                .build();

        // Tworzenie kategorii i dodanie książek
        Category fiction = new Category("Fikcja");
        fiction.addComponent(book1);
        fiction.addComponent(book2);
        fiction.addComponent(book3);

        // Wyświetlenie struktury Composite
        fiction.displayBookTitle();

        // Bridge - system rekomendacji
        RecommendationEngine engine = new RecommendationEngine();
        engine.setStrategy(new PurchaseHistoryRecommendation());
        engine.executeRecommendation();

        // Decorator - recenzje
        Review review = new PremiumReviewDecorator(new BasicReview("Świetna książka"));
        System.out.println(review.getContent());
    }
}
// Koniec - Tydzień 3, Testowanie wzorców projektowych, Joanna Kozar
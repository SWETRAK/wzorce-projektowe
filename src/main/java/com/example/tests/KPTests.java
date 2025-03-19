package com.example.tests;

import com.example.models.Author;
import com.example.models.books.AudioBook;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.discount.MultipleDiscount;
import com.example.models.discount.PriceDiscount;
import com.example.models.discount.SingleDiscount;
import com.example.services.delivery.DHLServiceAdapter;
import com.example.services.delivery.DeliveryService;
import com.example.services.delivery.InPostServiceAdapter;
import com.example.services.display.BestsellerDisplayDecorator;
import com.example.services.display.BookDisplay;
import com.example.services.display.HardCoverBookDisplayDecorator;
import com.example.services.display.SimpleBookDisplay;

import java.util.Collections;
import java.util.Date;

public class KPTests {

    public static void main(String[] args) {
        // Adapter
        DeliveryService dhlDelivery = new DHLServiceAdapter();
        DeliveryService inPostDelivery = new InPostServiceAdapter();
        dhlDelivery.deliverOrder("123");
        inPostDelivery.deliverOrder("456");

        // Composite
        PriceDiscount seasonalDiscount = new SingleDiscount(0.8);
        PriceDiscount specialOffer = new SingleDiscount(0.9);
        MultipleDiscount multipleDiscount = new MultipleDiscount();
        multipleDiscount.addDiscount(seasonalDiscount);
        multipleDiscount.addDiscount(specialOffer);
        multipleDiscount.applyDiscount(100);
        System.out.println("Final price after discounts: " + multipleDiscount.getSalePrice());

        // Bridge
        Author author1 = new Author("Andrzej", "Sapkowski");
        Author author2 = new Author("John Ronald Reuel", "Tolkien");

        Book ebook = new Book.Builder("The Last Wish", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        Book audiobook = new Book.Builder("The Hobbit", "Desc", Collections.singletonList(author2), new Date(), new AudioBook())
                .ISBNIdentifier("054792822X")
                .genre("Fantasy")
                .publisher("George Allen & Unwin")
                .pages(310)
                .build();

        ebook.showBookInfo();
        ebook.showBookInfo();

        // Decorator
        BookDisplay simplaeBookDisplay = new SimpleBookDisplay(audiobook);
        BookDisplay hardCoverBookDisplay = new HardCoverBookDisplayDecorator(simplaeBookDisplay);
        BookDisplay bestsellerBookDisplay = new BestsellerDisplayDecorator(hardCoverBookDisplay);
        bestsellerBookDisplay.showBookInfo();
    }
}

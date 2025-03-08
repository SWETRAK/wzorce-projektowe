package com.example.tests;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.movies.BlueRayMovie;
import com.example.models.movies.BlueRayMovieFactory;
import com.example.models.movies.DVDMovie;
import com.example.models.utils.InvoicingService;

import java.util.Collections;
import java.util.Date;

public class MPTests {
    public static void main(String[] args) {
        BookTest();
        SingletonTest();
        MovieTest();
    }

    public static void BookTest()
    {
        System.out.println("\nBuilder test for Book\n");
        Author author1 = new Author("Andrzej", "Sapkowski");
        Author author2 = new Author("John Ronald Reuel", "Tolkien");

        Book book1 = new Book.Builder("The Last Wish", "Desc", Collections.singletonList(author1), new Date())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        Book book2 = new Book.Builder("The Hobbit", "Desc", Collections.singletonList(author2), new Date())
                .ISBNIdentifier("054792822X")
                .genre("Fantasy")
                .publisher("George Allen & Unwin")
                .pages(310)
                .build();

        System.out.println(book1);
        System.out.println(book2);

        System.out.println("\nBuilder test for Book end\n");
    }

    public static void MovieTest()
    {
        System.out.println("\nFactory Prototype test for Movie\n");

        BlueRayMovie blueRayMovie1 = new BlueRayMovie("The Lord of the Rings: The Fellowship of the Ring", "Desc", 178, new Date(), "Fantasy", Collections.singletonList(new Author("Peter", "Jackson")));

        System.out.println(blueRayMovie1);

        BlueRayMovie blueRayMovie2 = new BlueRayMovieFactory().createMovie("The Lord of the Rings: The Two Towers", "Desc", 179, new Date(), "Fantasy", Collections.singletonList(new Author("Peter", "Jackson")));

        BlueRayMovie blueRayMovie3 = (BlueRayMovie) blueRayMovie2.copy();

        System.out.println(blueRayMovie3);

        DVDMovie dvdMovie1 = new DVDMovie("The Lord of the Rings: The Return of the King", "Desc", 201, new Date(), "Fantasy", Collections.singletonList(new Author("Peter", "Jackson")));
        System.out.println(dvdMovie1);

        System.out.println("\nFactory Prototype test for Movie end\n");
    }

    public static void SingletonTest()
    {
        System.out.println("\nSingleton test for invoice\n");

        InvoicingService invoicingService1 = InvoicingService.getInstance();
        invoicingService1.printInvoice("Invoice 1");

        System.out.println("\nSingleton test for invoice end\n");
    }

}

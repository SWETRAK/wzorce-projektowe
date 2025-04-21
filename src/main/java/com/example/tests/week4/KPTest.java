package com.example.tests.week4;

import com.example.models.Author;
import com.example.models.books.AudioBook;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.cart.CartItem;
import com.example.models.cart.ProductCartItem;
import com.example.models.delivery.DeliveryInfo;
import com.example.models.users.Client;
import com.example.services.books.BookSearchEngine;
import com.example.services.books.WarehouseRepository;
import com.example.services.delivery.DeliveryFactory;
import com.example.services.user.UserAccountService;

import java.util.Collections;
import java.util.Date;

public class KPTest {

    public static void main(String[] args) {

        // Facade
        Author author1 = new Author("Andrzej", "Sapkowski");
        Author author2 = new Author("John Ronald Reuel", "Tolkien");

        Client client = new Client.Builder("Klient", "Pierwszy", "klient.pierwszy@gmail.com")
                .phoneNumber("123456789")
                .build();

        Book book = new Book.Builder("The Last Wish", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        CartItem cartItem = new ProductCartItem(book, 45, 1);

        Book bookWishlist= new Book.Builder("The Hobbit", "Desc", Collections.singletonList(author2), new Date(), new AudioBook())
                .ISBNIdentifier("054792822X")
                .genre("Fantasy")
                .publisher("George Allen & Unwin")
                .pages(310)
                .build();

        CartItem cartItemWishlist = new ProductCartItem(bookWishlist, 45, 1);

        UserAccountService user = new UserAccountService(client);
        user.updateProfile("kamil@example.com", "Kamilek", "Pietrak");
        user.addPurchase(cartItem);
        user.addToWishlist(cartItemWishlist);
        user.showAccountInfo();

        // Proxy
        WarehouseRepository warehouseRepository = new WarehouseRepository();
        BookSearchEngine bookSearchEngine = new BookSearchEngine(warehouseRepository);
        System.out.println(bookSearchEngine.searchBook("The Hobbit"));
        System.out.println(bookSearchEngine.searchBook("The Hobbit"));

        // Flyweight
        DeliveryInfo delivery1 = DeliveryFactory.getDeliveryInfo("DHL", "12345");
        DeliveryInfo delivery2 = DeliveryFactory.getDeliveryInfo("DHL", "12345");
        delivery1.displayDeliveryDetails();
        System.out.println("Czy delivery1 i delivery2 to ten sam obiekt? " + (delivery1 == delivery2));
    }
}

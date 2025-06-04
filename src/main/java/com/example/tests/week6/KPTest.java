package com.example.tests.week6;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.cart.ProductCartItem;
import com.example.models.users.Client;
import com.example.models.users.memento.ClientCaretaker;
import com.example.services.delivery.DHLServiceAdapter;
import com.example.services.delivery.InPostServiceAdapter;
import com.example.services.delivery.mediator.DeliveryComponent;
import com.example.services.delivery.startegies.DHLStrategy;
import com.example.services.delivery.startegies.DeliveryContext;
import com.example.services.delivery.startegies.InPostStrategy;
import com.example.services.exporter.CSVExporter;
import com.example.services.exporter.Exporter;
import com.example.services.exporter.XMLExporter;
import com.example.services.order.stock.StockSystem;
import com.example.services.order.stock.WarehouseObserver;
import com.example.services.user.register.RegistrationContext;

import java.util.Collections;
import java.util.Date;

public class KPTest {

    public static void main(String[] args) {
        testObserver();
        testState();
        testStrategy();
        testTemplate();
        testVisitor();
        testMemento();
    }

    // Tydzień 6, Wzorzec Observer, Kamil Pietrak
    private static void testObserver() {
        System.out.println("=== OBSERVER ===");
        Author author = new Author("Andrzej", "Sapkowski");
        Book book = new Book.Builder("Java Programming", "Desc", Collections.singletonList(author), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();


        ProductCartItem cartItem = new ProductCartItem(book, 45, 1);

        StockSystem stockSystem = new StockSystem();
        stockSystem.addObserver(new WarehouseObserver());
        stockSystem.updateStock(cartItem);
    }

    // Tydzień 6, Wzorzec State, Kamil Pietrak
    private static void testState() {
        System.out.println("\n=== STATE ===");
        RegistrationContext registration = new RegistrationContext();
        registration.nextStep();
        registration.nextStep();
        registration.nextStep();
    }

    // Tydzień 6, Wzorzec Strategy, Kamil Pietrak
    private static void testStrategy() {
        System.out.println("\n=== STRATEGY ===");
        DeliveryContext delivery = new DeliveryContext();
        delivery.setStrategy(new DHLStrategy(new DHLServiceAdapter()));
        delivery.executeDelivery("PKG123");
        delivery.setStrategy(new InPostStrategy(new InPostServiceAdapter()));
        delivery.executeDelivery("PKG456");
    }

    // Tydzień 6, Wzorzec Template, Kamil Pietrak
    private static void testTemplate() {
        System.out.println("\n=== TEMPLATE ===");
        DeliveryComponent dhl = new DHLServiceAdapter();
        dhl.shipPackage("PKG-DHL-001");

        DeliveryComponent inPost = new InPostServiceAdapter();
        inPost.shipPackage("PKG-INPOST-002");
    }

    // Tydzień 6, Wzorzec Visitor, Kamil Pietrak
    private static void testVisitor() {
        System.out.println("\n=== VISITOR ===");
        Author author1 = new Author("Andrzej", "Sapkowski");
        Book book = new Book.Builder("Java Programming", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();
        Exporter csv = new CSVExporter();
        Exporter xml = new XMLExporter();
        book.accept(csv);
        book.accept(xml);
    }

    // Tydzień 6, Wzorzec Memento, Kamil Pietrak
    private static void testMemento() {
        System.out.println("\n=== MEMENTO ===");

        Client client = new Client.Builder("Klient", "Pierwszy", "klient.pierwszy@gmail.com")
                .phoneNumber("123456789")
                .build();

        ClientCaretaker clientCaretaker = new ClientCaretaker();

        client.setEmail("klient.pierwszy.nowy@gmail.com");
        clientCaretaker.save(client);

        client.setEmail("klient.pierwszy.nowy.dane@gmail.com");
        clientCaretaker.save(client);

        client.setEmail("klient.pierwszy.nowy.text@gmail.com");

        clientCaretaker.undo(client);
        clientCaretaker.undo(client);
    }

}

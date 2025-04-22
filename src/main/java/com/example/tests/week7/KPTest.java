package com.example.tests.week7;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.books.PhysicalBook;
import com.example.models.cart.ProductCartItem;
import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;
import com.example.services.books.BookSearchManager;
import com.example.services.books.BookSearchType;
import com.example.services.books.DatabaseBookSearch;
import com.example.services.books.StockUpdater;
import com.example.services.books.WarehauseBookSearch;
import com.example.services.books.WarehouseBookRepository;
import com.example.services.delivery.DHLServiceAdapter;
import com.example.services.delivery.DeliveryManager;
import com.example.services.delivery.DeliveryScheduler;
import com.example.services.delivery.InPostServiceAdapter;
import com.example.services.delivery.processes.DeliveryType;
import com.example.services.delivery.startegies.DeliveryContext;
import com.example.services.exporter.ExportManager;
import com.example.services.exporter.ExporterType;
import com.example.services.external.CalendarService;
import com.example.services.order.InvoiceGenerator;
import com.example.services.order.facade.InvoiceManager;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class KPTest {

    public static void main(String[] args) {
        SRPTest();
        OCPTestOne();
        OCPTestTwo();
        OCPTestThree();
    }

    private static void SRPTest() {
        WarehouseBookRepository warehouseBookRepository = new WarehouseBookRepository();
        StockUpdater stockUpdater = new StockUpdater(warehouseBookRepository);
        stockUpdater.updateStock("BOOK001", 50);

        DeliveryScheduler scheduler = new DeliveryScheduler(new CalendarService());
        scheduler.scheduleDelivery("Main St 5", "2025-04-20");

        InvoiceManager invoiceManager = new InvoiceManager();
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

        String orderId = "ORD-" + System.currentTimeMillis();

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(invoiceManager);
        invoiceGenerator.generateInvoice(regularClient, cart, orderId);
    }

    private static void OCPTestOne() {
        WarehouseBookRepository warehouseBookRepository = new WarehouseBookRepository();
        DatabaseBookSearch databaseBookSearch = new DatabaseBookSearch();
        WarehauseBookSearch warehouseBookSearch = new WarehauseBookSearch(warehouseBookRepository);

        BookSearchManager bookManager = new BookSearchManager(databaseBookSearch, warehouseBookSearch);
        bookManager.search(BookSearchType.DATABASE, "Clean Code");
        bookManager.search(BookSearchType.WAREHOUSE, "Java Basics");
    }

    private static void OCPTestTwo() {
        DeliveryContext context = new DeliveryContext();
        InPostServiceAdapter inPostServiceAdapter = new InPostServiceAdapter();
        DHLServiceAdapter dhlServiceAdapter = new DHLServiceAdapter();

        DeliveryManager deliveryManager = new DeliveryManager(dhlServiceAdapter, inPostServiceAdapter, context);

        Map<DeliveryType, String> packages = new HashMap<>();
        packages.put(DeliveryType.DHL, "PKG01");
        packages.put(DeliveryType.INPOST, "PKG02");
        deliveryManager.deliver(packages);
    }

    private static void OCPTestThree() {
        Book book1 = new Book.Builder("Java Programming", "Desc", Collections.singletonList(new Author("Andrzej", "Sapkowski")), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        Book book2 = new Book.Builder("Harry Potter i Czara Ognia", "Magiczna historia", Collections.singletonList(new Author("J.K.", "Rowling")), new Date(), null)
                .genre("Fantasy")
                .publisher("Media Rodzina")
                .pages(500)
                .build();

        ExportManager exportManager = new ExportManager();

        exportManager.export(ExporterType.XML, book1);
        exportManager.export(ExporterType.CSV, book2);
    }
}

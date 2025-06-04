package com.example.tests.week7;

import com.example.models.Author;
import com.example.models.books.AudioBook;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.cart.ProductCartItem;
import com.example.models.cart.ShoppingCart;
import com.example.models.users.Client;
import com.example.services.books.strategy.*;
import com.example.services.invoice.InvoiceExportFormat;
import com.example.services.invoice.InvoiceExportManager;
import com.example.services.order.BasicOrder;
import com.example.services.order.command.*;
import com.example.services.order.handler.OrderHandlerManager;
import com.example.services.order.handler.OrderType;
import com.example.services.user.ClientHistoryManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MPTests {
    public static void main(String[] args) {
        testSRPOrderProcessor();
        testSPRBookSorter();
        testSPRClientHistoryManager();
        testOCOrderHandler();
        testOCSortingStrategy();
        testOCInvoiceExporter();
    }

    private static void testSRPOrderProcessor() {
        System.out.println("\n--- SPR Order Processor Test ---");

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

    private static void testSPRBookSorter()
    {
        System.out.println("\n--- SPR Book Sorter Test ---");

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
        BookSorter bookSorter = new BookSorter();
        bookSorter.setCatalog(bookCatalog);
        bookSorter.setSortingStrategy(new DateSortingStrategy());

        System.out.println("Books sorted by date:");
        for (Book book : bookSorter.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getPublishedDate());
        }

        bookSorter.setSortingStrategy(new GenreSortingStrategy());
        System.out.println("\nBooks sorted by genre:");
        for (Book book : bookSorter.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getGenre());
        }

        bookSorter.setSortingStrategy(new PageCountSortingStrategy());

        System.out.println("\nBooks sorted by page count:");
        for (Book book : bookSorter.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getPages());
        }

        bookSorter.setSortingStrategy(new PublisherSortingStrategy());

        System.out.println("\nBooks sorted by publisher:");
        for (Book book : bookSorter.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getPublisher());
        }

        bookSorter.setSortingStrategy(new AuthorSortingStrategy());
        System.out.println("\nBooks sorted by author:");
        for (Book book : bookSorter.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getAuthors());
        }

        bookSorter.setSortingStrategy(new TitleSortingStrategy());

        System.out.println("\nBooks sorted by title:");
        for (Book book : bookSorter.getSortedBooks()) {
            System.out.println(book.getTitle()+ ", "+book.getTitle());
        }
    }

    private static void testSPRClientHistoryManager()
    {
        System.out.println("\n--- SPR Client History Manager Test ---");

        Client client = new Client.Builder("Klient", "Pierwszy", "klient.pierwszy@gmail.com")
                .phoneNumber("123456789")
                .build();

        ClientHistoryManager clientHistoryManager = new ClientHistoryManager(client);

        client.setEmail("klient.pierwszy.nowy@gmail.com");
        clientHistoryManager.save();

        System.out.println("Current email: " + clientHistoryManager.getClientEmail());

        client.setEmail("klient.pierwszy.nowy.dane@gmail.com");
        clientHistoryManager.save();

        System.out.println("Current email: " + clientHistoryManager.getClientEmail());

        client.setEmail("klient.pierwszy.nowy.text@gmail.com");

        System.out.println("Current email: " + clientHistoryManager.getClientEmail());

        clientHistoryManager.undo();

        System.out.println("Current email after undo: " + clientHistoryManager.getClientEmail());
        clientHistoryManager.undo();

        System.out.println("Current email after undo: " + clientHistoryManager.getClientEmail());
    }

    private static void testOCOrderHandler() {
        System.out.println("\n--- OC Order Handler Test ---");


        Client client = new Client.Builder("Jan", "Kowalski", "jan.kowalski@example.com")
                .phoneNumber("123456789")
                .address("ul. Główna 123, Warszawa")
                .build();

        ShoppingCart cart = new ShoppingCart();
        Book book = new Book.Builder("Java Programming", "Guide to Java",
                Collections.singletonList(new Author("John", "Doe")), new Date(), new Ebook())
                .build();
        cart.addItem(new ProductCartItem(book, 49.99, 1));

        OrderHandlerManager manager = new OrderHandlerManager();

        System.out.println("\nProcessing physical order:");
        manager.getHandler(OrderType.PHYSICAL).processOrder("ORD-001", client, cart);

        System.out.println("\nProcessing digital order:");
        manager.getHandler(OrderType.DIGITAL).processOrder("ORD-002", client, cart);

        System.out.println("\nCancelling orders:");
        manager.getHandler(OrderType.PHYSICAL).cancelOrder("ORD-001");
        manager.getHandler(OrderType.DIGITAL).cancelOrder("ORD-002");
    }

    private static void testOCSortingStrategy()
    {
        System.out.println("\n=== OC Sorting Strategy Test ===");

        List<Book> books = new ArrayList<>();
        Author author1 = new Author("J.K.", "Rowling");
        Author author2 = new Author("George R.R.", "Martin");

        Book book1 = new Book.Builder("Harry Potter", "Magic",
                Collections.singletonList(author1), new Date(), new Ebook())
                .genre("Fantasy")
                .pages(300)
                .build();

        Book book2 = new Book.Builder("Game of Thrones", "Epic fantasy",
                Collections.singletonList(author2), new Date(), new Ebook())
                .genre("Fantasy")
                .pages(800)
                .build();

        books.add(book1);
        books.add(book2);

        BookCatalog catalog = new BookCatalog(books);
        EnhancedBookSorter sorter = new EnhancedBookSorter(catalog);

        System.out.println("\nBooks sorted by title:");
        sorter.getSortedBooks(SortStrategyType.TITLE).forEach(book ->
                System.out.println(book.getTitle())
        );

        System.out.println("\nBooks sorted by page count:");
        sorter.getSortedBooks(SortStrategyType.PAGES).forEach(book ->
                System.out.println(book.getTitle() + " - " + book.getPages() + " pages")
        );
    }

    private static void testOCInvoiceExporter() {
        System.out.println("\n=== Invoice Exporter Test ===");

        BasicOrder order = new BasicOrder("ORD-003", 129.99);
        InvoiceExportManager exportManager = new InvoiceExportManager();

        System.out.println("\nExporting invoice to CSV:");
        exportManager.exportInvoice(order, "/exports/invoice_123.csv", InvoiceExportFormat.CSV);

        System.out.println("\nExporting invoice to XML:");
        exportManager.exportInvoice(order, "/exports/invoice_123.xml", InvoiceExportFormat.XML);

        System.out.println("\nExporting invoice to PDF:");
        exportManager.exportInvoice(order, "/exports/invoice_123.pdf", InvoiceExportFormat.PDF);
    }
}

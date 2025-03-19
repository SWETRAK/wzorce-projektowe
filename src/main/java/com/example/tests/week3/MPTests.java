package com.example.tests.week3;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.books.PhysicalBook;
import com.example.models.cart.ProductCartItem;
import com.example.models.cart.ShoppingCart;
import com.example.services.books.BookProvider;
import com.example.services.books.ExternalBookProviderAdapter;
import com.example.services.external.ExternalBookProviderService;
import com.example.services.notification.EmailNotificationSender;
import com.example.services.notification.OrderNotification;
import com.example.services.notification.SMSNotificationSender;
import com.example.services.order.BasicOrder;
import com.example.services.order.ExpressDeliveryDecorator;
import com.example.services.order.GiftWrappingDecorator;
import com.example.services.order.Order;

import java.util.Collections;
import java.util.Date;

public class MPTests {
    public static void main(String[] args) {
        testAdapter();
        testComposite();
        testBridge();
        testDecorator();
    }

    private static void testAdapter() {
        System.out.println("\n--- Adapter Pattern Test ---");
        ExternalBookProviderService externalService = new ExternalBookProviderService();
        BookProvider adapter = new ExternalBookProviderAdapter(externalService);

        adapter.findBooks("Bardzo fajna książka");
        adapter.getBookInfo("9780134685991");
        adapter.orderBook("9780134685991", 5);
    }

    private static void testComposite() {
        System.out.println("\n--- Composite Pattern Test ---");
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

        cart.display();
    }

    private static void testBridge() {
        System.out.println("\n--- Bridge Pattern Test ---");
        OrderNotification emailNotification = new OrderNotification(
                new EmailNotificationSender(),
                "ORD-12345"
        );
        emailNotification.send("customer@example.com");

        OrderNotification smsNotification = new OrderNotification(
                new SMSNotificationSender(),
                "ORD-12345"
        );
        smsNotification.send("+1234567890");
    }

    private static void testDecorator() {
        System.out.println("\n--- Decorator Pattern Test ---");
        Order basicOrder = new BasicOrder("ORD-12345", 99.99);
        basicOrder.process();

        System.out.println("\nWith decorators:");
        Order decoratedOrder = new ExpressDeliveryDecorator(
                new GiftWrappingDecorator(basicOrder, 2.99),
                3.99
        );
        decoratedOrder.process();
    }
}

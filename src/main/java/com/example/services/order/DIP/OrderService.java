package com.example.services.order.DIP;

// Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
//Klasa testowa dla zasady DIP
import com.example.services.books.DIP.BookSource;
import com.example.services.notification.DIP.UserNotifier;
import com.example.services.payment.DIP.PaymentProcessor;

public class OrderService {
    private final PaymentProcessor payment;
    private final UserNotifier notifier;
    private final BookSource source;

    public OrderService(PaymentProcessor payment, UserNotifier notifier, BookSource source) {
        this.payment = payment;
        this.notifier = notifier;
        this.source = source;
    }

    public void placeOrder(String isbn, double price) {
        System.out.println(source.fetchBook(isbn));
        payment.process(price);
        notifier.notify("Twoje zamówienie zostało zrealizowane.");
    }
}
// Koniec - Tydzień 8 – Zasada Odwrócenia Zależności (DIP) - Joanna Kozar
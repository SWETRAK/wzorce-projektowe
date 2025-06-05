package com.example.tests.week6;

import com.example.models.accountstate.*;
import com.example.models.books.Book;
import com.example.models.Author;
import com.example.models.books.Ebook;
import com.example.models.users.Client;
import com.example.services.discount.PromotionCalculator;
import com.example.services.discount.*;
import com.example.services.notification.PromotionService;
import com.example.services.payment.*;
import com.example.services.reporting.*;
import com.example.models.bookhistory.*;

import java.util.Collections;
import java.util.Date;

public class JKTest {
    public static void main(String[] args) {
        runObserverExample();
        runStateExample();
        runStrategyExample();
        runTemplateExample();
        runVisitorExample();
        runMementoExample();
    }

    public static void runObserverExample() {
        System.out.println("=== OBSERVER ===");
        PromotionService promoService = new PromotionService();
        Client c1 = new Client("Asia", "Kozar", "aaa@bjn.dg", "Blik", "123456789", "aaa78");
        promoService.subscribe(c1);
        promoService.notifyObservers("Nowa promocja -50% na ebooki!");
    }

    public static void runStateExample() {
        System.out.println("\n=== STATE ===");
        UserAccount account = new UserAccount();
        account.handle(); // aktywne
        account.setState(new SuspendedState());
        account.handle(); // zawieszone
    }

    public static void runStrategyExample() {
        System.out.println("\n=== STRATEGY ===");
        PromotionCalculator calculator = new PromotionCalculator();
        calculator.setStrategy(new RegularCustomerStrategy());
        System.out.println("Cena dla klienta zwykłego: " + calculator.calculate(100));
        calculator.setStrategy(new VipCustomerStrategy());
        System.out.println("Cena dla VIP: " + calculator.calculate(100));
    }

    public static void runTemplateExample() {
        System.out.println("\n=== TEMPLATE ===");
        PayPalAdapter paypalProcessor = new PayPalAdapter(new PayPalPayment());
        BlikAdapter stripeProcessor = new BlikAdapter(new BlikPayment());

        PaymentTemplate card = new CardPaymentTemplate();
        PaymentTemplate blik = new BlikPaymentTemplate(stripeProcessor);
        PaymentTemplate payPal = new PayPalPaymentTemplate(paypalProcessor);
        card.processPayment(88.45);
        blik.processPayment(99.45);
        payPal.processPayment(102.5);
    }

    public static void runVisitorExample() {
        System.out.println("\n=== VISITOR ===");
        Author author = new Author("J.K.", "Rowling");
        Book book = new Book.Builder("Harry Potter i Czara Ognia", "Magiczna historia", Collections.singletonList(author), new Date(), null)
                .genre("Fantasy")
                .publisher("Media Rodzina")
                .pages(500)
                .build();
        ReportGenerator visitor = new ReportGenerator();
        book.accept(visitor);
    }

    public static void runMementoExample() {
        System.out.println("\n=== MEMENTO ===");
        Author author = new Author("Andrzej", "Sapkowski");
        Book book = new Book.Builder("Java Programming", "Desc", Collections.singletonList(author), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();
        book.showBookInfo();

        BookMemento snapshot = book.save(); // zapisz stan
        book.setTitle("Zmieniony tytuł");
        book.setDescription("Zmieniony opis");
        book.showBookInfo();

        book.restore(snapshot); // przywróć poprzedni stan
        book.showBookInfo();
    }
}



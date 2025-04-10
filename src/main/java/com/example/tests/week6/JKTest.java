//package com.example.tests.week6;
//
//import com.example.models.accountstate.*;
//import com.example.models.bookhistory.EditableBook;
//import com.example.models.books.Book;
//import com.example.models.books.BookComponent;
//import com.example.models.books.BookWithFormat;
//import com.example.models.books.Ebook;
//import com.example.services.reporting.*;
//import com.example.services.discount.*;
//import com.example.services.notification.*;
//import com.example.services.payment.*;
//import com.example.models.Author;
//import com.example.models.users.*;
//
//import java.util.Collections;
//import java.util.Date;
//
//public class JKTest {
//    public static void main(String[] args) {
//
//        // Observer – Powiadamianie klientów o promocjach
//        PromotionService promotionService = new PromotionService();
//        Client client1 = new Client("Asia","Kozar", "aaa@aa.a", "Blik", "123456789", "AAA37");
//        Client client2 = new Client("Kamil","Pietrak", "bbb@aa.a", "Card", "456789123", "BBB98");
//        Client client3 = new Client("Maciek","Potręć", "ccc@aa.a", "Paypal", "789456123", "CCC54");
//        promotionService.addObserver(client1);
//        promotionService.addObserver(client2);
//        promotionService.addObserver(client3);
//        promotionService.sendPromotion("Zniżka 20% na e-booki!");
//
//        System.out.println();
//
//        // State – Stan konta użytkownika
//        UserAccount account = new UserAccount();
//        AccountState accountState = new ActiveState();
//        account.activate();
//        account.suspend();
//        account.activate();
//
//        System.out.println();
//
//        // Strategy – Promocje zależne od typu klienta
//        PromotionCalculator calculator = new PromotionCalculator();
//        calculator.setStrategy(new VipCustomer());
//        System.out.println("Zniżka VIP: " + calculator.calculateDiscount(200));
//        calculator.setStrategy(new RegularCustomer());
//        System.out.println("Zniżka Regular: " + calculator.calculateDiscount(200));
//
//        System.out.println();
//
//        // Template – Procesy płatności (karta, przelew, blik)
//        PaymentTemplate cardPayment = new CardPayment();
//        cardPayment.processOrder();
//        PaymentTemplate blikPayment = new BlikPayment();
//        blikPayment.processOrder();
//
//        System.out.println();
//
//        // Visitor – Raportowanie danych produktów
//        Author author = new Author("Joanne", "Rowling");
//        BookComponent book = new Book.Builder(
//                "Czara Ognia", "Harry Potter 4",
//                Collections.singletonList(author), new Date(), new Ebook()
//        ).build();
//        ProductVisitor visitor = new ReportGenerator();
//        book.accept(visitor);
//
//        System.out.println();
//
//        // Memento – Historia edycji książki przez administratora
//        EditableBook editableBook = new EditableBook("Stary tytuł", "Stary opis");
//        editableBook.saveState(); // zapamiętanie wersji 1
//        editableBook.edit("Nowy tytuł", "Nowy opis");
//        editableBook.saveState(); // zapamiętanie wersji 2
//        editableBook.edit("Jeszcze nowszy tytuł", "Jeszcze nowszy opis");
//
//        System.out.println("Aktualna wersja: " + editableBook.getTitle());
//        editableBook.restoreState(1); // powrót do wersji 2
//        System.out.println("Po przywróceniu: " + editableBook.getTitle());
//    }
//}
//
package com.example.tests.week6;

import com.example.models.accountstate.*;
import com.example.models.books.Book;
import com.example.models.Author;
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
        // Tydzień 6, OBSERVER – powiadamianie o promocjach, Joanna Kozar
        System.out.println("=== OBSERVER ===");
        PromotionService promoService = new PromotionService();
        Client c1 = new Client("Asia", "Kozar", "aaa@bjn.dg","Blik", "123456789", "aaa78");
        promoService.subscribe(c1);
        promoService.notifyObservers("Nowa promocja -50% na ebooki!");

        // Tydzień 6, STATE – stan konta użytkownika, Joanna Kozar
        System.out.println("\n=== STATE ===");
        UserAccount account = new UserAccount();
        account.handle(); // aktywne
        account.setState(new SuspendedState());
        account.handle(); // zawieszone

        //Tydzień 6, STRATEGY – promocje zależne od klienta, Joanna Kozar
        System.out.println("\n=== STRATEGY ===");
        PromotionCalculator calculator = new PromotionCalculator();
        calculator.setStrategy(new RegularCustomer());
        System.out.println("Cena dla klienta zwykłego: " + calculator.calculate(100));
        calculator.setStrategy(new VipCustomer());
        System.out.println("Cena dla VIP: " + calculator.calculate(100));

        // Tydzień 6, TEMPLATE – różne metody płatności, Joanna Kozar
        System.out.println("\n=== TEMPLATE ===");
        PaymentTemplate card = new CardPayment();
        PaymentTemplate blik = new BlikPaymentTemplate();
        card.processPayment();
        blik.processPayment();

        //Tydzień 6,  VISITOR – raportowanie danych o książce, Joanna Kozar
        System.out.println("\n=== VISITOR ===");
        Author author = new Author("J.K.", "Rowling");
        Book book = new Book.Builder("Harry Potter i Czara Ognia", "Magiczna historia", Collections.singletonList(author), new Date(), null)
                .genre("Fantasy")
                .publisher("Media Rodzina")
                .pages(500)
                .build();
        ReportGenerator visitor = new ReportGenerator();
        book.accept(visitor);

        //Tydzień 6,  MEMENTO – historia edycji książki, Joanna Kozar
        System.out.println("\n=== MEMENTO ===");
        EditableBook editable = new EditableBook();
        editable.setTitle("Harry Potter i Czara Ognia");
        editable.setDescription("Opis oryginalny");
        editable.print();

        BookMemento snapshot = editable.save(); // zapisz stan
        editable.setTitle("Zmieniony tytuł");
        editable.setDescription("Zmieniony opis");
        editable.print();

        editable.restore(snapshot); // przywróć poprzedni stan
        editable.print();
    }
}


package com.example.tests.week5;

import com.example.models.Author;
import com.example.models.books.Book;
import com.example.models.books.Ebook;
import com.example.models.cart.CartItem;
import com.example.models.cart.ProductCartItem;
import com.example.models.cart.ShoppingCart;
import com.example.services.books.interpreter.BookTitleContainsExpression;
import com.example.services.books.interpreter.Expression;
import com.example.services.cart.AddToCartCommand;
import com.example.services.cart.CartCommand;
import com.example.services.delivery.DHLServiceAdapter;
import com.example.services.delivery.DeliverySystem;
import com.example.services.delivery.InPostServiceAdapter;
import com.example.services.delivery.mediator.DeliveryMediator;

import java.util.Collections;
import java.util.Date;

public class KPTests {

    public static void main(String[] args) {
        testCommand();
        testInterpreter();
        testIterator();
        testMediator();
    }

    private static void testCommand()
    {
        Author author1 = new Author("Andrzej", "Sapkowski");
        Book book = new Book.Builder("The Last Wish", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        CartItem cartItem = new ProductCartItem(book, 45, 1);

        ShoppingCart cart = new ShoppingCart();
        CartCommand command = new AddToCartCommand(cart, cartItem);

        command.execute();
        cart.display();

        command.undo();
        cart.display();
    }

    private static void testInterpreter()
    {
        Author author1 = new Author("Andrzej", "Sapkowski");

        Expression expression = new BookTitleContainsExpression("Java");

        Book book = new Book.Builder("Java Programming", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        Book book2 = new Book.Builder("Python Programming", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        System.out.println("Java Programming contains Java? " + expression.interpret(book));
        System.out.println("Python Programming contains Java? " + expression.interpret(book2));
    }

    private static void testIterator()
    {
        Author author1 = new Author("Andrzej", "Sapkowski");
        Book book = new Book.Builder("Java Programming", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        Book book2 = new Book.Builder("Python Programming", "Desc", Collections.singletonList(author1), new Date(), new Ebook())
                .ISBNIdentifier("0316333522")
                .genre("Fantasy")
                .publisher("SuperNowa")
                .pages(288)
                .build();

        CartItem cartItem = new ProductCartItem(book, 45, 1);

        CartItem cartItem2 = new ProductCartItem(book2, 60, 1);

        ShoppingCart shopping = new ShoppingCart();

        shopping.addItem(cartItem);
        shopping.addItem(cartItem2);

        while (shopping.hasNext()) {
            shopping.next().display();
        }

        while (shopping.hasPrevious()) {
            shopping.getPrevious().display();
        }
    }

    private static void testMediator()
    {
        DeliveryMediator mediator = new DeliveryMediator();
        DeliverySystem orderSystem = new DeliverySystem(mediator);
        DHLServiceAdapter dhlDeliveryService = new DHLServiceAdapter(mediator);
        InPostServiceAdapter inPostServiceAdapter = new InPostServiceAdapter(mediator);

        mediator.registerComponent(orderSystem);
        mediator.registerComponent(dhlDeliveryService);
        mediator.registerComponent(inPostServiceAdapter);

        orderSystem.placeOrder();
    }
}

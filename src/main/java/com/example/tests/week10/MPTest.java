package com.example.tests.week10;

import com.example.functional.interfaces.EmailSender;
import com.example.functional.interfaces.ShoppingCartManager;
import com.example.functional.interfaces.StockValidator;
import com.example.models.Author;
import com.example.models.albums.Album;
import com.example.models.albums.AlbumBuilder;
import com.example.models.cart.ShoppingCart;
import com.example.models.enums.AlbumType;
import com.example.models.movies.BlueRayMovie;
import com.example.models.movies.Movie;
import com.example.models.users.Client;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MPTest {

    public static void main(String[] args) {
        LambdaTest();
        StreamTest();
        PredicateAndFunctionTest();
    }

    //Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
    //Implementacja i użycie wyrażeń lambda.
    public static void LambdaTest()
    {
        EmailSender emailSender = (recipient, subject, body) -> {
            System.out.println("\n");
            System.out.println("Wysyłanie e-maila:");
            System.out.println("Odbiorca: " + recipient);
            System.out.println("Temat: " + subject);
            System.out.println("Treść: " + body);
        };
        StockValidator stockValidator = (stockItem, quantity) -> {
            System.out.println("\n");
            System.out.println("Walidacja pozycji magazynowej:");
            System.out.println("Pozycja: " + stockItem);
            System.out.println("Ilość: " + quantity);
            return quantity > 0;
        };
        ShoppingCartManager shoppingCartManager = (cartContent, invoiceContent, stockContent) -> {
            System.out.println("\n");
            System.out.println("Zarządzanie koszykiem:");
            System.out.println("Zawartość koszyka: " + cartContent);
            System.out.println("Zawartość faktury: " + invoiceContent);
            System.out.println("Zawartość magazynu: " + stockContent);
        };


        String cartContent = "Koszyk z produktami";
        String invoiceContent = "Faktura za zakupy";
        String stockContent = "Stan magazynowy";
        String emailContent = "Wiadomość e-mail do klienta";
        String recipient = "user@gmai.com";

        shoppingCartManager.manageCart(cartContent, invoiceContent, stockContent);
        emailSender.sendEmail(recipient, "Temat wiadomości", emailContent);
        boolean isValid = stockValidator.validate("Produkt A", 5);
        System.out.println("Czy pozycja magazynowa jest poprawna? " + isValid);
    }
    //Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć

    //Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
    //Strumieniowe przetwarzanie danych
    public static void StreamTest()
    {
        List<Album> albums = List.of(
                new AlbumBuilder()
                        .setTitle("Album 1")
                        .setType(AlbumType.CD)
                        .setAuthor(new Author("Jan", "Kowalski"))
                        .build(),
                new AlbumBuilder()
                        .setTitle("Album 2")
                        .setType(AlbumType.CD)
                        .setAuthor(new Author("Jan", "Kowalski"))
                        .build(),
                new AlbumBuilder()
                        .setTitle("Album 3")
                        .setType(AlbumType.CD)
                        .setAuthor(new Author("Jan", "Kowalski"))
                        .build()
        );
        System.out.println("\nOdtwarzanie albumów:");
        albums.stream()
                .forEach(Album::play);


        List<Movie> movies = List.of(
                new BlueRayMovie("Film 1", "Reżyser 1", 120, new Date(), "Action", Collections.singletonList(new Author("Jan", "Kowalski"))),
                new BlueRayMovie("Film 2", "Reżyser 2", 150, new Date(), "Drama", Collections.singletonList(new Author("Jan", "Kowalski"))),
                new BlueRayMovie("Film 3", "Reżyser 3", 90, new Date(), "Comedy", Collections.singletonList(new Author("Jan", "Kowalski")))
        );

        System.out.println("\nMovies sorted from longest to shortest:");
        movies.stream()
                .sorted((m1, m2) -> Integer.compare(m2.getDuration(), m1.getDuration()))
                .forEach(movie -> System.out.println(movie.getTitle() + " - " + movie.getDuration() + " minutes"));

        System.out.println("\n");

        List<Client> clients = List.of(
                new Client("Jan", "Kowalski", "jankowalski@gmail.com", "blik", "123456789", "Lublin"),
                new Client("Anna", "Nowak", "anna.nowak@gmail.com", "credit", "987654321", "Warszawa"),
                new Client("Piotr", "Wiśniewski", "piotr.wisniewski@gmail.com", "paypal", "555123456", "Kraków"),
                new Client("Magdalena", "Lewandowska", "magda.lew@gmail.com", "blik", "678123456", "Lublin"),
                new Client("Tomasz", "Kamiński", "tomasz.kaminski@gmail.com", "debit", "789456123", "Lublin")
        );

        System.out.println("\nKlienci z Lublina:");
        clients.stream()
                .filter(client -> client.getAddress().equals("Lublin"))
                .forEach(client -> System.out.println(client.getFirstName() + " " + client.getLastName()));
    }
    //Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć

    //Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
    //Wykorzystanie interfejsów Predicate i Function.
    public static void PredicateAndFunctionTest()
    {
        Predicate<List<Client>> isAnyClientFromLublin = clients -> clients.stream()
                .anyMatch(client -> client.getAddress().equals("Lublin"));
        Function<List<Client>, Integer> countClientsFromLublin = clients -> (int) clients.stream()
                .filter(client -> client.getAddress().equals("Lublin"))
                .count();

        List<Client> clients = List.of(
                new Client("Jan", "Kowalski", "jankowalski@gmail.com", "blik", "123456789", "Lublin"),
                new Client("Anna", "Nowak", "anna.nowak@gmail.com", "credit", "987654321", "Warszawa"),
                new Client("Piotr", "Wiśniewski", "piotr.wisniewski@gmail.com", "paypal", "555123456", "Kraków"),
                new Client("Magdalena", "Lewandowska", "magda.lew@gmail.com", "blik", "678123456", "Lublin"),
                new Client("Tomasz", "Kamiński", "tomasz.kaminski@gmail.com", "debit", "789456123", "Lublin")
        );

        System.out.println("\nCzy jest jakikolwiek klient z Lublina? " + isAnyClientFromLublin.test(clients));
        System.out.println("Liczba klientów z Lublina: " + countClientsFromLublin.apply(clients));
    }
    //Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Maciej Potręć
}

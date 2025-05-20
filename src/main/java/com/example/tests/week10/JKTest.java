package com.example.tests.week10;

import com.example.functional.interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JKTest {
    public static void main(String[] args) {
        //Tydzień 10, Zasada Programowanie Funkcyjne, Joanna Kozar
        //Implementacja i użycie wyrażeń lambda.
        BookFormatter formatter = (title, author) -> "Title: " + title + ", Author: " + author;
        DiscountCalculator discount10 = price -> price * 0.9;
        UserNotifier consoleNotifier = msg -> System.out.println("Notify: " + msg);

        String formatted = formatter.format("Wiedźmin", "Sapkowski");
        double discounted = discount10.calculate(100);
        consoleNotifier.notifyUser("Promocja -10% na " + formatted);
        System.out.println("Cena po rabacie: " + discounted);

        //Tydzień 10, Zasada Programowanie Funkcyjne, Joanna Kozar
        //Strumieniowe przetwarzanie trzech kolekcji
        List<String> authors = Arrays.asList("Sapkowski", "Tolkien", "Rowling");
        List<Integer> pages = Arrays.asList(312, 423, 517);
        List<Double> prices = Arrays.asList(39.99, 49.99, 29.99);

        List<String> filteredAuthors = authors.stream()
                .filter(a -> a.startsWith("S") || a.length() > 6)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> shortBooks = pages.stream()
                .filter(p -> p < 500)
                .collect(Collectors.toList());

        double total = prices.stream()
                .filter(p -> p > 30)
                .mapToDouble(p -> p)
                .sum();

        System.out.println("Autorzy: " + filteredAuthors);
        System.out.println("Książki krótsze niż 500 stron: " + shortBooks);
        System.out.println("Suma cen książek >30zł: " + total);

        //Tydzień 10, Zasada Programowanie Funkcyjne , Joanna Kozar
        //Wykorzystanie interfejsów Predicate i Function.
        Predicate<String> longTitle = title -> title.length() > 10;
        Function<String, Integer> titleLength = String::length;

        String sampleTitle = "Harry Potter i Czara Ognia";
        if (longTitle.test(sampleTitle)) {
            System.out.println("Długość tytułu: " + titleLength.apply(sampleTitle));
        } else {
            System.out.println("Tytuł jest krótki.");
        }
    }
}



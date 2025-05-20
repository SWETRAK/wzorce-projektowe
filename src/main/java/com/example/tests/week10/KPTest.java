package com.example.tests.week10;

import com.example.functional.interfaces.BookProcessor;
import com.example.functional.interfaces.DeliveryNotifier;
import com.example.functional.interfaces.InvoiceValidator;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class KPTest {

    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
    }

    //Tydzień 10, Zasada Programowanie Funkcyjne, Kamil Pietrak
    //Implementacja i użyciem wyrażeń lambda.
    public static void Task1() {
        System.out.println("=== TASK 1 ===");
        BookProcessor processor = title -> "Processed Book: " + title;
        DeliveryNotifier notifier = id -> System.out.println("Package notified: " + id);
        InvoiceValidator validator = content -> content != null && content.length() > 10;

        System.out.println(processor.process("Clean Code"));
        notifier.notify("PKG001");
        System.out.println("Invoice valid: " + validator.validate("Invoice #2025 - Paid"));
    }


    //Tydzień 10, Zasada Programowanie Funkcyjne, Kamil Pietrak
    //Strumieniowe przetwarzanie trzech kolekcji przy użyciu API Stream.
    public static void Task2() {
        System.out.println("=== TASK 2 ===");

        List<String> books = List.of("Clean Code", "Effective Java", "Java Concurrency");
        List<Integer> lengths = books.stream().map(String::length).toList();
        System.out.println("Lengths: " + lengths);

        List<String> packages = List.of("PKG1", "PKG2", "PKG3");
        packages.stream().filter(p -> p.endsWith("3")).forEach(System.out::println);

        List<Double> prices = List.of(99.9, 149.5, 199.0);
        double total = prices.stream().reduce(0.0, Double::sum);
        System.out.println("Total price: " + total);
    }


    //Tydzień 10, Zasada Programowanie Funkcyjne , Kamil Pietrak
    //Wykorzystanie interfejsów Predicate i Function.
    public static void Task3() {
        System.out.println("=== TASK 3 ===");

        Predicate<String> isLongTitle = title -> title.length() > 10;
        Function<String, Integer> titleLength = String::length;

        String book = "Java Programming Guide";
        System.out.println("Is long title: " + isLongTitle.test(book));
        System.out.println("Title length: " + titleLength.apply(book));
    }

}
//Koniec, Tydzień 10, Kamil Pietrak
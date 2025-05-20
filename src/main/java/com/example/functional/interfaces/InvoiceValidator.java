package com.example.functional.interfaces;

//Tydzień 10, Zasada Programowanie Funkcyjne, Kamil Pietrak
//Interfejs funkcyjny do walidowania faktury
@FunctionalInterface
public interface InvoiceValidator {
    boolean validate(String invoiceContent);
}
//Koniec, Tydzień 10, Zasada Programowanie Funkcyjne, Kamil Pietrak
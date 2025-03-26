package com.example.services.publisher;

// Tydzień 4, Wzorzec Proxy, Joanna Kozar
// Klasa rzeczywistego API wydawnictwa
public class PublisherAPI implements PublisherInterfaceAPI {
    @Override
    public String getBookInfo(String ISBN) {
        // Symulacja zapytania do API wydawnictwa
        System.out.println("Pobieranie danych z API dla ISBN: " + ISBN);
        return "Dane o książce dla ISBN: " + ISBN;
    }
}

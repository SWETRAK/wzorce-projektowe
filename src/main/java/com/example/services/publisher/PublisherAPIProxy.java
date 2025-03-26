package com.example.services.publisher;
import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Proxy, Joanna Kozar
// Klasa proxy cache'ująca odpowiedzi API wydawnictwa, aby ograniczyć liczbę zapytań
public class PublisherAPIProxy implements PublisherInterfaceAPI {
    private final PublisherAPI realAPI;
    private final Map<String, String> cache = new HashMap<>();

    public PublisherAPIProxy() {
        this.realAPI = new PublisherAPI();
    }

    @Override
    public String getBookInfo(String isbn) {
        if (cache.containsKey(isbn)) {
            System.out.println("Pobieranie danych z cache dla ISBN: " + isbn);
            return cache.get(isbn);
        }
        System.out.println("Pobieranie danych z API dla ISBN: " + isbn);
        String bookInfo = realAPI.getBookInfo(isbn);
        cache.put(isbn, bookInfo);
        return bookInfo;
    }
}
//Koniec - Tydzień 4, Wzorzec Proxy, Joanna Kozar
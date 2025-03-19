package com.example.services.external;

// Tydzień 3, Wzorzec Adapter, Maciej Potręć
// Klasa dostawcy książek zewnętrznego systemu
public class ExternalBookProviderService {
    public void searchBooksByTitle(String title) {
        System.out.println("Searching for books with title: " + title);
    }

    public void fetchBookDetails(String isbn) {
        System.out.println("Fetching details for ISBN: " + isbn);
    }

    public void placeOrder(String isbn, int quantity) {
        System.out.println("Ordering " + quantity + " copies of ISBN: " + isbn);
    }
}
// Koniec, Tydzień 3, Wzorzec Adapter, Maciej Potręć

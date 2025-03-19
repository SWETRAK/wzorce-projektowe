package com.example.services.books;

import com.example.services.external.ExternalBookProviderService;

// Tydzień 3, Wzorzec Adapter, Maciej Potręć
// Adapter umożliwiający integrację zewnętrznego dostawcy książek z naszym systemem
public class ExternalBookProviderAdapter implements BookProvider {
    private final ExternalBookProviderService externalService;

    public ExternalBookProviderAdapter(ExternalBookProviderService externalService) {
        this.externalService = externalService;
    }

    @Override
    public void findBooks(String query) {
        System.out.println("Adapter: Converting query to external format");
        externalService.searchBooksByTitle(query);
    }

    @Override
    public void getBookInfo(String isbn) {
        System.out.println("Adapter: Requesting book info from external provider");
        externalService.fetchBookDetails(isbn);
    }

    @Override
    public void orderBook(String isbn, int quantity) {
        System.out.println("Adapter: Placing order through external provider");
        externalService.placeOrder(isbn, quantity);
    }
}
// Koniec, Tydzień 3, Wzorzec Adapter, Maciej Potręć

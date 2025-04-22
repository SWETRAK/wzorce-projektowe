package com.example.services.books;

// Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
// Klasa do wyszukiwania książek w bazie danych magazynu zewnętrznego (dropshipping)
public class WarehauseBookSearch implements BookSearch {

    private final WarehouseBookRepository warehouseBookRepository;

    public WarehauseBookSearch(WarehouseBookRepository warehouseBookRepository) {
        this.warehouseBookRepository = warehouseBookRepository;
    }

    @Override
    public String searchBook(String title) {
        return warehouseBookRepository.searchBook(title);
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Koniec, Tydzień 7, Zasada OCP (Abstrakcja), Kamil Pietrak
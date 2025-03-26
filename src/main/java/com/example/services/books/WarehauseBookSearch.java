package com.example.services.books;

// Tydzień 4, Wzorzec Proxy, Kamil Pietrak
// Klasa do wyszukiwania książek w bazie danych magazynu zewnętrznego (dropshipping)
public class WarehauseBookSearch implements BookSearch {
    @Override
    public String searchBook(String title) {
        return "Book found in warehouse: " + title;
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy, Kamil Pietrak
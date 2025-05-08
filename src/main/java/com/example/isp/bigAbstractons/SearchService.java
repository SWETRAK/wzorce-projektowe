package com.example.isp.bigAbstractons;

import com.example.isp.models.Location;
import com.example.models.books.Book;

import java.util.List;

// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// SearchService jako przykład "grubego" interfejsu wyszukiwania.
public interface SearchService {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    Book findByISBN(String isbn);
    List<Book> findByLocation(Location location);
    List<Book> findByPriceRange(double min, double max);
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 2
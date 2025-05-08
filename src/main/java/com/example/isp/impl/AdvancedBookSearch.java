package com.example.isp.impl;

import com.example.isp.abstractons.AuthorSearch;
import com.example.isp.abstractons.TitleSearch;
import com.example.models.books.Book;

import java.util.Collections;
import java.util.List;

// Tydzień 8, Zasada Segregacji Interfejsów, Kamil Pietrak
// AdvancedBookSearch implementujący wybrane interfejsy wyszukiwania.
public class AdvancedBookSearch implements TitleSearch, AuthorSearch {
    public List<Book> findByTitle(String title) {
        // Implementacja wyszukiwania po tytule
        return Collections.emptyList();
    }

    public List<Book> findByAuthor(String author) {
        // Implementacja wyszukiwania po autorze
        return Collections.emptyList();
    }
}
//Koniec, Tydzień 8, Zasada Segregacji Interfejsów (ISP) 8

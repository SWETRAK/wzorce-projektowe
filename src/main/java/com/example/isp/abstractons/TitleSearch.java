package com.example.isp.abstractons;

import com.example.models.books.Book;

import java.util.List;

public interface TitleSearch {
    List<Book> findByTitle(String title);
}

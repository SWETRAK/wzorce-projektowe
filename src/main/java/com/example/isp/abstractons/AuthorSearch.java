package com.example.isp.abstractons;

import com.example.models.books.Book;

import java.util.List;

public interface AuthorSearch {
    List<Book> findByAuthor(String author);
}

package com.example.isp.abstractons;

import com.example.models.books.Book;

public interface ISBNSearch {
    Book findByISBN(String isbn);
}

package com.example.services.books.interpreter;

import com.example.models.books.Book;

// Tydzień 5, Wzorzec Interpreter, Kamil Pietrak
// Klasa sprawdzająca, czy tekst zawiera dane słowo kluczowe
public class BookTitleContainsExpression implements Expression {

    private String keyword;

    public BookTitleContainsExpression(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean interpret(Book book) {
        return book.getTitle().contains(keyword);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Kamil Pietrak

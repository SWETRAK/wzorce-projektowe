package com.example.services.books.interpreter;

import com.example.models.books.Book;

// Tydzień 5, Wzorzec Interpreter, Kamil Pietrak
// Interfejs dla wyrażeń interpretowanych
public interface Expression {
    boolean interpret(Book book);
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Kamil Pietrak

package com.example.services.reporting;

import com.example.models.books.Book;

//Tydzień 6, wzorzec Visitor, Joanna Kozar
//Implementacja interfejsu do raportowania danych produktów
public interface ProductVisitor {
    void visit(Book book);
}
//Koniec - Tydzień 6, wzorzec Visitor, Joanna Kozar

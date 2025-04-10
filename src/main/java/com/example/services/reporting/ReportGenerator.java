package com.example.services.reporting;

import com.example.models.books.Book;

//Tydzień 6, wzorzec Visitor, Joanna Kozar
//Implementacja klasy do generowania raportowów danych produktów
public class ReportGenerator implements ProductVisitor {
    public void visit(Book book) {
        System.out.println("Raport: " + book.getTitle() + " – " + book.getGenre());
    }
}
//Koniec - Tydzień 6, wzorzec Visitor, Joanna Kozar

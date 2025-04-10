package com.example.models.books;

import com.example.services.reporting.ProductVisitor;

// Tydzień 3, Wzorzec Composite, Joanna Kozar
// Interfejs wspólny dla książek i kategorii, umożliwiający jednolitą obsługę
public interface BookComponent {
    void displayBookTitle();

    //Tydzień 6, Wzorzec Visitor, Joanna Kozar
    //dodanie do interfejsu metody akceptacji umożliwiającej raportowanie danych produktów
    void accept(ProductVisitor visitor);
    //Koniec - Tydzień 6, Wzorzec Visitor, Joanna Kozar

}
//Koniec - Tydzień 3, Wzorzec Composite, Joanna Kozar

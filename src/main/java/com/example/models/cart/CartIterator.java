package com.example.models.cart;

// Tydzień 5, Wzorzec Iterator, Kamil Pietrak
// Interfejs iteratora do przechodzenia po książkach w koszyku
public interface CartIterator {
    boolean hasNext();
    CartItem next();
    CartItem getPrevious();

    boolean hasPrevious();
}
// Koniec, Tydzień 5, Wzorzec Iterator, Kamil Pietrak
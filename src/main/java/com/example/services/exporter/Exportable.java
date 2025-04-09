package com.example.services.exporter;

// Tydzień 6, Wzorzec Visitor, Kamil Pietrak
// Interfejs pozwalający obiektowi być odwiedzanym przez eksportera danych
public interface Exportable {
    void accept(Exporter visitor);
}
// Koniec, Tydzień 6, Wzorzec Visitor, Kamil Pietrak
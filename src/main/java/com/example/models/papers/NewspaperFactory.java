package com.example.models.papers;

// Tydzień 1, Wzorzec factory, Kamil Pietrak
// Klasa factory dla typu newspaper, która dziedziczy po abstrakcyjnej klasie generycznej, do której został przekazany typ
public class NewspaperFactory extends PaperFactory<Newspaper> {

    @Override
    protected Newspaper createPaper(String ISDNIdentifier) {
        return new Newspaper(ISDNIdentifier);
    }
}
// Koniec, Wzorzec factory, Kamil Pietrak
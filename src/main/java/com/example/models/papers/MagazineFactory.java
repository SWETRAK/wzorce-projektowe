package com.example.models.papers;

// Tydzień 1, Wzorzec factory, Kamil Pietrak
// Klasa factory dla typu magazine, która dziedziczy po abstrakcyjnej klasie generycznej, do której został przekazany typ
public class MagazineFactory extends PaperFactory<Magazine> {

    @Override
    protected Magazine createPaper(String ISDNIdentifier) {
        return new Magazine(ISDNIdentifier);
    }
}
// Koniec, Wzorzec factory, Kamil Pietrak




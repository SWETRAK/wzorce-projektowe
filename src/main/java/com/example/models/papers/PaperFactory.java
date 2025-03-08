package com.example.models.papers;

// Tydzień 1, Wzorzec factory, Kamil Pietrak
// Generyczna klasa fabryki Paper, która przyjmuje generyczny typ, który musi rozszerzać typ generyczny Paper.
// Funkcja create pozwala utworzyć nowy obiekt generycznego typu, a metoda createPaper definiuje sposób tworzenia dla konkretnych typów generycznych
public abstract class PaperFactory<TPaperType extends Paper> {

    public TPaperType create(String ISDNIdentifier) {
        TPaperType paper = createPaper(ISDNIdentifier);
        paper.build();
        return paper;
    }

    protected abstract TPaperType createPaper(String ISDNIdentifier);
}
// Koniec, Wzorzec factory, Kamil Pietrak

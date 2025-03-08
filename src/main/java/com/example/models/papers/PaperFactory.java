package com.example.models.papers;

// Tydzień 1, Wzorzec factory, Kamil Pietrak
// Generyczna klasa fabryki Paper, która przyjmuje generyczny typ, który musi rozszerzać typ generyczny Paper.
// Funkcja create pozwala utworzyć nowy obiekt generycznego typu, a metoda createPaper definiuje sposób tworzenia dla konkretnych typów generycznych
public abstract class PaperFactory<TPaperType extends Paper> {

    public TPaperType create(String ISSNIdentifier) {
        TPaperType paper = createPaper(ISSNIdentifier);
        paper.build();
        return paper;
    }

    protected abstract TPaperType createPaper(String ISSNIdentifier);
}
// Koniec, Wzorzec factory, Kamil Pietrak

package com.example.models.albums;


//tydzień 1, wzorzec Prototype, Joanna Kozar
//interfejs Album definiuje podstawowe metody dla obiektów muzycznych
//metoda clone() umożliwia tworzenie kopii albumu
public interface Album {
    void play();
    Album clone();
}
//tydzień 1 koniec wzorca Prototype - Joanna Kozar
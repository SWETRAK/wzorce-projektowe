package com.example.models.albums;


//Tydzień 2, wzorzec Prototype, Joanna Kozar
//interfejs Album definiuje podstawowe metody dla obiektów muzycznych
//metoda clone() umożliwia tworzenie kopii albumu
public interface Album {
    void play();
    Album clone();
}
//Tydzień 2 Koniec wzorca Prototype - Joanna Kozar
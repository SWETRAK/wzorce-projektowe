package com.example.models.albums;
import com.example.models.Author;
import com.example.models.enums.AlbumType;

// Tydzień 1, wzorzec Factory Method, Joanna Kozar
// klasa Album Factory odpowiada za tworzenie obiektów Album na podstawie podanego typu

public class AlbumFactory {
    public static Album createAlbum(AlbumType type, String title, Author author) {
        System.out.println("Tworzenie albumu typu: " + type);
        return switch (type) {
            case CD -> new CDAlbum(title, author);
            case VINYL -> new VinylAlbum(title, author);
        };
    }
}
// tydzień 1, koniec wzorca Factory Method, Joanna Kozar
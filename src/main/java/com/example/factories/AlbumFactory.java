package com.example.factories;

import com.example.models.Album;
import com.example.models.CDAlbum;
import com.example.models.VinylAlbum;

// Tydzień 1, wzorzec Factory Method, Joanna Kozar
// klasa Album Factory odpowiada za tworzenie obiektów Album na podstawie podanego typu

public class AlbumFactory {
    public static Album createAlbum(String type, String title, String artist) {
        System.out.println("Tworzenie albumu typu: " + type);
        return switch (type.toLowerCase()) {
            case "cd" -> new CDAlbum(title, artist);
            case "vinyl" -> new VinylAlbum(title, artist);
            default -> throw new IllegalArgumentException("Nieznany typ albumu: " + type);
        };
    }
}
// tydzień 1, koniec wzorca Factory Method, Joanna Kozar
package com.example.builders;

import com.example.models.Album;
import com.example.models.CDAlbum;
import com.example.models.VinylAlbum;

// Tydzień 1, Wzorzec Builder, Joanna Kozar
// Klasa AlbumBuilder umożliwia stopniowe tworzenie obiektów Album

public class AlbumBuilder {
    private String type;
    private String title;
    private String artist;

    public AlbumBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public AlbumBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public AlbumBuilder setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public Album build() {
        if (type == null || title == null || artist == null) {
            throw new IllegalStateException("Brakuje danych do stworzenia albumu!");
        }

        return switch (type.toLowerCase()) {
            case "cd" -> new CDAlbum(title, artist);
            case "vinyl" -> new VinylAlbum(title, artist);
            default -> throw new IllegalArgumentException("Nieznany typ albumu: " + type);
        };
    }
}

// tydzień 1, koniec wzorca Builder, Joanna Kozar

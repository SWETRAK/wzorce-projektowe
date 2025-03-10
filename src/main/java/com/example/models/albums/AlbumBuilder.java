package com.example.models.albums;

// Tydzień 1, Wzorzec Builder, Joanna Kozar
// Klasa AlbumBuilder umożliwia stopniowe tworzenie obiektów Album

import com.example.models.Author;
import com.example.models.enums.AlbumType;

import static com.example.models.enums.AlbumType.CD;
import static com.example.models.enums.AlbumType.VINYL;

public class AlbumBuilder {
    private AlbumType type;
    private String title;
    private Author author;

    public AlbumBuilder setType(AlbumType type) {
        this.type = type;
        return this;
    }

    public AlbumBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public AlbumBuilder setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Album build() {
        if (type == null || title == null || author == null) {
            throw new IllegalStateException("Brakuje danych do stworzenia albumu!");
        }

        return switch (type) {
            case CD -> new CDAlbum(title, author);
            case VINYL -> new VinylAlbum(title, author);
        };
    }
}

// tydzień 1, koniec wzorca Builder, Joanna Kozar

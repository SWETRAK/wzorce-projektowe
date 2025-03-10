package com.example.models.albums;

// Tydzień 1, Wzorzec Builder, Joanna Kozar
// Klasa AlbumBuilder umożliwia stopniowe tworzenie obiektów Album

import com.example.models.Author;
import com.example.models.enums.AlbumType;

public class AlbumBuilder {
    private String type;
    private String title;
    private Author author;

    public AlbumBuilder setType(AlbumType type) {
        this.type = String.valueOf(type);
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

        return switch (type.toLowerCase()) {
            case "cd" -> new CDAlbum(title, author);
            case "vinyl" -> new VinylAlbum(title, author);
            default -> throw new IllegalArgumentException("Nieznany typ albumu: " + type);
        };
    }
}

// tydzień 1, koniec wzorca Builder, Joanna Kozar

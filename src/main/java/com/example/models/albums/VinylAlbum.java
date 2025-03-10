package com.example.models.albums;

// Tydzień 1, Wzorzec Prototype, Joanna Kozar
// Klasa VinylAlbum implemntuje interfejs Album i reprezentuje album muzyczny w winylu

import com.example.models.Author;

public class VinylAlbum implements Album {
    private String title;
    private Author author;

        public VinylAlbum(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void play() {
        System.out.println("Odtwarzanie Winylu: " + title + " - " + author);
    }

    @Override
    public Album clone() {
        return new VinylAlbum(this.title, this.author);
    }

    @Override
    public String toString() {
        return "VinylAlbum{" + "title='" + title + '\'' + ", artist='" + author + '\'' + '}';
    }
}
// tydzień 1, koniec wzorca Prototype, Joanna Kozar
package com.example.models;

// Tydzień 1, Wzorzec Prototype, Joanna Kozar
// Klasa VinylAlbum implemntuje interfejs Album i reprezentuje album muzyczny w winylu

public class VinylAlbum implements Album {
    private String title;
    private String artist;

    public VinylAlbum(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Odtwarzanie Winylu: " + title + " - " + artist);
    }

    @Override
    public Album clone() {
        return new VinylAlbum(this.title, this.artist);
    }

    @Override
    public String toString() {
        return "VinylAlbum{" + "title='" + title + '\'' + ", artist='" + artist + '\'' + '}';
    }
}
// tydzień 1, koniec wzorca Prototype, Joanna Kozar
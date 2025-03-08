package com.example.models;

// Tydzień 1, Wzorzec Prototype, Joanna Kozar
// klasa CDAlbum implementuje interfejs Album i reprezentuje album muzyczny w formacie CD

public class CDAlbum implements Album {
    private String title;
    private String artist;

    public CDAlbum(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Odtwarzanie CD: " + title + " - " + artist);
    }

    @Override
    public Album clone() {
        return new CDAlbum(this.title, this.artist);
    }

    @Override
    public String toString() {
        return "CDAlbum{" + "title='" + title + '\'' + ", artist='" + artist + '\'' + '}';
    }
}
// tydzień 1 koniec wzorca Prototype, Joanna Kozar
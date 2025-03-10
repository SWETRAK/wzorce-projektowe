package com.example.models.albums;
import com.example.models.Author;
import com.example.models.Song;

import java.util.ArrayList;
import java.util.List;

// Tydzień 1, Wzorzec Prototype, Joanna Kozar
// klasa CDAlbum implementuje interfejs Album i reprezentuje album muzyczny w formacie CD

public class CDAlbum implements Album {
    private String title;
    private Author author;
    private List<Song> tracklist;

    public CDAlbum(String title, Author author) {
        this.title = title;
        this.author = author;
        this.tracklist = new ArrayList<>();
    }

    public void addSong(String songTitle, double duration) {
        tracklist.add(new Song(songTitle, duration));
    }

    @Override
    public void play() {
        System.out.println("Odtwarzanie CD: " + title + " - " + author);
        for (Song song : tracklist) {
            System.out.println(song.getTitle() + " - " + song.getDuration());
        }
    }

    @Override
    public Album clone() {
        CDAlbum copy = new CDAlbum(this.title, this.author);
        copy.tracklist = new ArrayList<>(this.tracklist);
        return copy;
    }

    @Override
    public String toString() {
        return "CDAlbum{" + "title='" + title + '\'' + ", artist='" + author + '\'' + ", tracklist=" + tracklist + '}';
    }
}
// tydzień 1 koniec wzorca Prototype, Joanna Kozar
package com.example.models;


//tydzień 1, klasa Song, Joanna Kozar
//klasa Song reprezentuje pojedynczą piosenkę w albumie
public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " min)";
    }
}

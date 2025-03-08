package com.example;

import com.example.builders.AlbumBuilder;
import com.example.factories.AlbumFactory;
import com.example.models.Album;
import com.example.utils.Printer;

public class Main {
    public static void main(String[] args) {
        System.out.print("System księgarni");

        // Factory Method - tydzień 1 - Joanna Kozar
        System.out.println("Tworzenie albumów za pomocą FABRYKI...");
        Album cd = AlbumFactory.createAlbum("cd", "Hybrid Theory", "Linkin Park");
        Album vinyl = AlbumFactory.createAlbum("vinyl", "Dark Side of the Moon", "Pink Floyd");

        System.out.println("Utworzono: " + cd);
        System.out.println("Utworzono: " + vinyl + "\n");

        cd.play();
        vinyl.play();
        System.out.println();
        //koniec Factory - tydzień 1 - Joanna Kozar

        // Prototype - tydzień 1 - Joanna Kozar
        System.out.println("Tworzenie kopii albumów...");
        Album copyCd = cd.clone();
        Album copyVinyl = vinyl.clone();
        //koniec Prototype - tydzień 1 - Joanna Kozar

        System.out.println("Klon CD: " + copyCd);
        System.out.println("Klon Winylu: " + copyVinyl + "\n");

        // Builder - tydzień 1 - Joanna Kozar
        System.out.println("Tworzenie albumu za pomocą BUILDERA...");
        Album builderCd = new AlbumBuilder()
                .setType("cd")
                .setTitle("Nevermind")
                .setArtist("Nirvana")
                .build();

        System.out.println("Album z Buildera: " + builderCd);
        builderCd.play();
        //koniec Buildera - tydzień 1 - Joanna Kozar

        //Singleton - tydzień 1 - Joanna Kozar
        System.out.println("Drukowanie faktury...");
        Printer printer = Printer.getInstance();
        printer.printInvoice("Nevermind", "Nirvana");
        //koniec Singletona - tydzień 1 - Joanna Kozar


        System.out.println("\nWszystkie operacje zakończone!");
    }
}
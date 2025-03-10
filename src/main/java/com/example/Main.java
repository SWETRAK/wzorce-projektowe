package com.example;

import com.example.models.Author;
import com.example.models.albums.AlbumBuilder;
import com.example.models.albums.AlbumFactory;
import com.example.models.albums.Album;
import com.example.models.albums.CDAlbum;
import com.example.models.enums.AlbumType;
import com.example.models.utils.Printer;

import com.example.models.papers.Magazine;
import com.example.models.papers.MagazineFactory;
import com.example.models.papers.Newspaper;
import com.example.models.papers.NewspaperFactory;
import com.example.models.papers.Paper;
import com.example.models.users.Client;
import com.example.models.users.Manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.print("System księgarni");

        // Tworzenie autorów - tydzień 1 - Joanna Kozar
        Author linkinPark = new Author("Chester", "Bennington");
        Author pinkFloyd = new Author("David", "Gilmour");

        // Factory Method - tydzień 1 - Joanna Kozar
        System.out.println("Tworzenie albumów za pomocą FABRYKI...");
        Album cd = AlbumFactory.createAlbum(AlbumType.CD, "Hybrid Theory", linkinPark);
        Album vinyl = AlbumFactory.createAlbum(AlbumType.VINYL, "Dark Side of the Moon", pinkFloyd);

        System.out.println("Utworzono: " + cd);
        System.out.println("Utworzono: " + vinyl + "\n");

        cd.play();
        vinyl.play();
        System.out.println("Odtwarzanie zakończone");
        //koniec Factory - tydzień 1 - Joanna Kozar

        // Prototype - tydzień 1 - Joanna Kozar
        System.out.println("Tworzenie kopii albumów...");
        Album copyCd = cd.clone();
        Album copyVinyl = vinyl.clone();
        System.out.println("Klon CD: " + copyCd);
        System.out.println("Klon Winylu: " + copyVinyl + "\n");
        //koniec Prototype - tydzień 1 - Joanna Kozar

        // Dodanie piosenek do CDAlbum
        if (cd instanceof CDAlbum cdAlbum) {
            cdAlbum.addSong("Papercut", 3.04);
            cdAlbum.addSong("In The End", 3.36);
            cdAlbum.addSong("Crawling", 3.29);
            System.out.println("Dodano utwory do " + cdAlbum);
        }

        // Odtworzenie CD z piosenkami
        System.out.println("\nOdtwarzanie CD z piosenkami:");
        cd.play();
        System.out.println();

        //Builder - tydzień 1 - Joanna Kozar
        System.out.println("Tworzenie albumu za pomocą BUILDERA...");

        Author nirvana = new Author("Kurt", "Cobain");

        Album builderCd = new AlbumBuilder()
                .setType(AlbumType.CD)
                .setTitle("Nevermind")
                .setAuthor(nirvana)
                .build();

        System.out.println("Album z Buildera: " + builderCd);
        builderCd.play();
        //Koniec Buildera - tydzień 1 - Joanna Kozar



        //Singleton - tydzień 1 - Joanna Kozar
        System.out.println("Drukowanie faktury...");
        Printer printer = Printer.getInstance();
        printer.printInvoice("Nevermind", "Nirvana", 79.99);
        //koniec Singletona - tydzień 1 - Joanna Kozar


        System.out.println("\nWszystkie operacje zakończone!");
        System.out.println("System księgarni");

        Manager manager = Manager.getInstance();
        manager.printInfo();

        Client client1 = new Client.Builder("Klient", "Pierwszy", "klient.pierwszy@gmail.com")
                .phoneNumber("123456789")
                .build();

        client1.printInfo();

        Client client2 = new Client.Builder("Klient", "Drugi", "klient.drugi@gmail.com")
                .build();

        client2.printInfo();

        System.out.println("Client 1 phone number: " + client1.getPhoneNumber());
        System.out.println("Client 2 phone number: " + client2.getPhoneNumber());

        List<Paper> papers = new ArrayList<>();

        Newspaper newspaper1 = new NewspaperFactory().create("ISDN1");
        newspaper1.setDescription("Description1");
        newspaper1.setTitle("Title1");
        newspaper1.setPages(100);
        newspaper1.setPaperId(1);
        newspaper1.setPublishedDate(new Date());

        Newspaper newspaper2 = (Newspaper)newspaper1.copy();
        newspaper2.setPaperId(2);

        Magazine magazine1 = new MagazineFactory().create("ISDN2");
        magazine1.setDescription("Description2");
        magazine1.setTitle("Title2");
        magazine1.setPages(100);
        magazine1.setPaperId(3);
        magazine1.setPublishedDate(new Date());

        Magazine magazine2 = (Magazine)magazine1.copy();
        magazine2.setPaperId(3);

        papers.add(magazine1);
        papers.add(magazine2);
        papers.add(newspaper1);
        papers.add(newspaper2);

        papers.forEach(System.out::println);

    }
}
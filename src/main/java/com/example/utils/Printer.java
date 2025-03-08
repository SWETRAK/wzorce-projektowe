package com.example.utils;

// Tydzień 1, Wzorzec Singleton, Joanna Kozar
// Klasa Printer zapewnia istnienie tylko jednej instancji drukarki

public class Printer {
    private static Printer instance;

    private Printer() {
        System.out.println("Drukarka została uruchomiona.");
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void printInvoice(String albumTitle, String artist) {
        System.out.println("\nDrukowanie faktury...");
        System.out.println("----------------------------");
        System.out.println("Album: " + albumTitle);
        System.out.println("Artysta: " + artist);
        System.out.println("Cena: 49.99 PLN");
        System.out.println("Faktura wydrukowana!\n");
    }
}

// tydzień 1, koniec wzorca Singleton, Joanna Kozar